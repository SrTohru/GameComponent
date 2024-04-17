/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc.Pool;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.domaincomponent.domain.Pool;
import org.itson.domaincomponent.domain.Tile;
import org.itson.domaincomponent.exceptions.PoolException;
import org.itson.enums.ImagesSourcers;
import org.itson.mvc.tile.TileComponent;

/**
 *
 * @author PC
 */
public class PoolModel {

    private LinkedList<TileComponent> tiles;
    private Pool pool;
    private String poolImagePath;
    private int coordX;
    private int coordY;
    private int width;
    private int height;

    public PoolModel(int width, int height ,int coordX, int coordY) {
        this.poolImagePath = ImagesSourcers.getSOURCE_IMAGE_POOL();
        this.width = width;//120;
        this.height = height;//130;
        this.tiles = new LinkedList<>();
        this.coordX = coordX;//1110;
        this.coordY = coordY;//260;
        this.pool = Pool.getInstance();
    }

    public LinkedList<TileComponent> getTiles() {
        return tiles;
    }

    public void setTiles(LinkedList<Tile> tiles) {
        for (Tile tile : tiles) {
            this.getTiles().add(new TileComponent(tile));
        }
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    
    
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

    public String getPoolImagePath() {
        return poolImagePath;
    }

    public void setPoolImagePath(String poolImagePath) {
        this.poolImagePath = poolImagePath;
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
}
