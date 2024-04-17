package org.itson.mvc.board;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.itson.domaincomponent.enums.Orientation;
import org.itson.mvc.tile.TileComponent;

public class BoardView extends JPanel {

    private BoardModel boardModel;
    private Image boardImage; // Imagen de la primera cara

    public BoardView(BoardModel boardModel) {
        this.boardModel = boardModel;
        loadBoardImage();
        setPreferredSize(new Dimension(630, 500));
    }

    private void loadBoardImage() {
        try {
            boardImage = ImageIO.read(new File(boardModel.getBoardImagePath()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void refresh() {
        loadBoardImage();
        repaint();
        removeAll();
        paintTiles();
    }

    private void paintTiles() {
        if (boardHasTiles()) {
            addTilesComponentsToBoardView();
            revalidate();
            repaint();
        }
    }

    private void addTilesComponentsToBoardView() {
        for (TileComponent tile : this.boardModel.getTiles()) {
            if (tile != null && tile.getTile() != null) {
                this.add(tile.getTileView());
                tile.refresh();
                paintRotatedTile(tile.getTileView().createImage(), tile.getTileModel().getOrientation());
            }
        }
    }

    private boolean boardHasTiles() {
        return (this.boardModel.getTiles() != null && !this.boardModel.getTiles().isEmpty());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (boardImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(boardImage, boardModel.getCoordX(), boardModel.getCoordY(), this);
            g2d.dispose();
        }
    }

    private void paintRotatedTile(Image tileImage, Orientation orientation) {
        if (tileImage != null) {
            Graphics2D g2d = (Graphics2D) getGraphics().create();

            // Aplicar la rotación individual para cada ficha
            if (orientation == Orientation.HORIZONTAL) {
                g2d.rotate(Math.toRadians(90), getWidth() / 2, getHeight() / 2);
            } else if (orientation == Orientation.VERTICAL) {
                // Puedes agregar más casos según sea necesario
            }

            g2d.drawImage(tileImage, 0, 0, this);
            g2d.dispose();
        }
    }
}
