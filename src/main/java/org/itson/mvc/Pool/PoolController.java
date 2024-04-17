/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc.Pool;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.itson.domaincomponent.domain.Tile;
import org.itson.domaincomponent.exceptions.PoolException;
import org.itson.events.PoolEvents;
import org.itson.game.MatchGame;
import org.itson.mvc.tile.TileComponent;
import org.itson.interfaces.MatchObserver;

/**
 *
 * @author PC
 */
public class PoolController extends MouseAdapter {

    private PoolView poolView;
    private PoolModel poolModel;
    private List<MatchObserver> observers = new ArrayList<>();

    public PoolController(PoolView poolView, PoolModel poolModel) {
        this.poolView = poolView;
        this.poolModel = poolModel;
        this.suscribeToClick();
    }

    public void suscribe(MatchGame match) {
        addObserver(match);
    }

    public void createDominoTiles() throws PoolException {

        for (Tile tile :  this.poolModel.getPool().createDominoTiles()) {
            this.poolModel.getTiles().add(new TileComponent(tile));
        }

    }

    public TileComponent getTileFromPool() throws PoolException {

        Tile tile = this.poolModel.getPool().getRandomTile();

        for (TileComponent tiles : this.poolModel.getTiles()) {

            if (tile == tiles.getTile()) {
                this.poolModel.getTiles().remove(tiles);
                return tiles;
            }
        }
        
        return null; 

    }

    public void refresh() {
        this.poolView.refresh();
    }

    private void suscribeToClick() {
        this.poolView.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
              if(SwingUtilities.isLeftMouseButton(evt)){
                  notifyObservers(PoolEvents.LEFT_CLICK_ON_POOL_EVENT);
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

    public void notifyObservers(PoolEvents message) {
        for (MatchObserver observer : observers) {
            observer.eventOnPoolUpdate(message);
        }
    }
}
