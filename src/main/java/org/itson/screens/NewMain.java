/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.screens; 

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import org.itson.domaincomponent.domain.FaceTile;
import org.itson.domaincomponent.domain.Tile;
import org.itson.mvc.tile.TileController;
import org.itson.mvc.tile.TileModel;
import org.itson.mvc.tile.TileView;

/**
 *
 * @author santi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        frmMatch formulario= new frmMatch();
        formulario.setVisible(true);
        
        
        
    }
}
       
//      
//  JFrame frame = new JFrame("My JFrame");
//
//        // Set the size of the JFrame
//        frame.setSize(600, 600);
//
//        // Set the location of the JFrame
//        frame.setLocationRelativeTo(null);
//
//        // Make the JFrame visible on the screen
//        frame.setVisible(true);
//        
//       TileModel model= new TileModel();
//       TileView view= new TileView(model);
//       TileController controller= new TileController(model,view);
//       frame.addMouseListener(controller);
//       System.out.println(frame.add(view));
//        frame.pack();
//       frame.add(view);
//             
   

