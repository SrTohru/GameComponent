package org.itson.mvc.Pool;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.itson.interfaces.MatchObserver;

public class PoolView extends JPanel {

    private PoolModel poolModel;
    private Image poolImage;
    private int poolWidth;
    private int poolHeight;
    

    public PoolView(PoolModel poolModel) {
        this.poolModel = poolModel;
        setPreferredSize(new Dimension(120, 130));
    }

    private void loadPoolImage() {
        try {
            poolImage = ImageIO.read(new File(poolModel.getPoolImagePath()));
            poolWidth = 120;
            poolHeight = 130;

        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción de manera adecuada
        }
    }

    public void refresh() {
        loadPoolImage();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibuja la imagen en el JPanel
        g2d.drawImage(poolImage, 0, 0, poolWidth, poolHeight, this);
    }

   

}
