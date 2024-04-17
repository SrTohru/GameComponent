/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc.board;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.itson.events.BoardEvents;
import org.itson.game.MatchGame;
import org.itson.mvc.tile.TileComponent;
import org.itson.interfaces.MatchObserver;

/**
 *
 * @author PC
 */
public class BoardController extends MouseAdapter{
    private BoardView boardView;
    private BoardModel boardModel;
    private List<MatchObserver> observers = new ArrayList<>();
    
    public BoardController(BoardView boardView, BoardModel boardModel){
        this.boardModel = boardModel;
        this.boardView = boardView;
        suscribeToClick();
    }
    
    public void suscribe(MatchGame match){
        this.addObserver(match);
    }
    
        public boolean canPlaceTile(TileComponent tile) {
        // Verificar si la ficha se puede colocar en el tablero
        if (boardModel.getTiles().isEmpty()) {
            // Si el tablero está vacío, cualquier ficha se puede colocar
            return true;
        } else {
            // Obtener la última ficha en el tablero
            TileComponent lastTile = boardModel.getTiles().getLast();

            // Verificar si los lados de la nueva ficha coinciden con los lados de la última ficha
            if (lastTile.getTile().getRightFace().getValue() == tile.getTile().getLeftFace().getValue()) {
                return true;  // Los lados derecho e izquierdo coinciden
            } else if (lastTile.getTile().getLeftFace().getValue() == tile.getTile().getRightFace().getValue()) {
                return true;  // Los lados izquierdo y derecho coinciden
            } else {
                return false;  // No se pueden colocar las fichas
            }
        }
    }
    
    public void addTileToBoard(TileComponent tile){
        this.boardModel.addTile(tile);
    }
    
    /*public void setTile(Tile tile){
        boardModel.setTile(tile);
    }*/

    public void refreshBoard() {
         this.boardView.refresh();
    }
        private void suscribeToClick() {
        this.boardView.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              if(SwingUtilities.isLeftMouseButton(evt)){
                  notifyObservers(BoardEvents.LEFT_CLICK_ON_BOARD_EVENT);
              }
            }
        });
    }
    
       public void addObserver(MatchObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(MatchObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(BoardEvents message) {
        for (MatchObserver observer : observers) {
            observer.eventOnBoardUpdate(message);
        }
    }
}
