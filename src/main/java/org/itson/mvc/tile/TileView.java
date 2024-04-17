/**
 * TileView.java
 * Oct 10, 2023 11:05:56 AM
 */
package org.itson.mvc.tile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.itson.domaincomponent.enums.Orientation;

public class TileView extends JPanel {

    private TileModel tileModel;
    private BufferedImage tile;
    private BufferedImage firstFaceImage; 
    private BufferedImage secondFaceImage; 

    public TileView(TileModel tileModel) {
        this.tileModel = tileModel;
        this.setPreferredSize(new Dimension(70, 55));
        loadFaceImages();
    }  
    
    private void loadFaceImages() {
        try {
            firstFaceImage = ImageIO.read(new File(tileModel.getFirstFacePath()));
            secondFaceImage = ImageIO.read(new File(tileModel.getSecondFacePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refresh() {
        if (verifyFacesImages()) {
            createImage();
            
            repaint();
        }
    }
    
    public boolean verifyFacesImages(){
        return firstFaceImage != null && secondFaceImage != null;
    }
    
    public BufferedImage createImage(){
        tile = new BufferedImage(tileModel.getWidth(), tileModel.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = tile.createGraphics();

            Image scaledFirstFaceImage = firstFaceImage.getScaledInstance(
                    tileModel.getWidth(), tileModel.getHeight() / 3, Image.SCALE_SMOOTH
            );

            Image scaledSecondFaceImage = secondFaceImage.getScaledInstance(
                    tileModel.getWidth(), tileModel.getHeight() / 3, Image.SCALE_SMOOTH
            );

            g2d.drawImage(scaledFirstFaceImage, 0, 0, this);
            g2d.drawImage(scaledSecondFaceImage, 0, tileModel.getHeight() / 3, this);

            g2d.dispose();
            
            return tile;
    }

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (tile != null) {
        Graphics2D g2d = (Graphics2D) g.create();

   

        g2d.drawImage(tile, 0, 0, this);
        g2d.dispose();
    }
}

  
}
