/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc.board;

import java.util.LinkedList;
import org.itson.domaincomponent.domain.Board;
import org.itson.domaincomponent.domain.Tile;
import org.itson.enums.ImagesSourcers;
import org.itson.mvc.tile.TileComponent;

/**
 *
 * @author PC
 */
public class BoardModel {
    private Board board;
    
    String boardImagePath;
    
    int coordX;

    int coordY;

    int width;

    int height;
    
    private LinkedList<TileComponent> tiles = new LinkedList<>();
  
    /*public BoardModel(){
    }*/
  
    public BoardModel(Board board){
      this.board = board;
      //this.tiles = board.getTiles();
  }
    
    public BoardModel(int width, int height, int coordX, int coordY) {
        this.width = width;//730;
        this.height = height;//630;
        this.coordX = coordX;
        this.coordY = coordY;
        this.boardImagePath = ImagesSourcers.getSOURCE_IMAGE_BOARD();
    }
    
    public TileComponent addTile(TileComponent tile){
        this.getTiles().add(tile);
        return tile;
    }
  
    public LinkedList<TileComponent> getTiles() {
        return tiles;
    }
    
    public void setTiles(LinkedList <TileComponent> tiles){
      this.tiles = tiles;
  }
    
    public TileComponent removeTile(TileComponent tile){
        this.tiles.remove(tile);
        return tile;
    }
    
    /*public void setTile(Tile tile){
        tiles.set(tiles.size(), tile);
    }*/
  
    public int getWidth() {
        return width;
    }

    public void setWidth(int weight) {
        this.width = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    
    public String getBoardImagePath() {
        return boardImagePath;
    }

    public void setBoardImagePath(String boardImagePath) {
        this.boardImagePath = boardImagePath;
    }
    
}
