/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.mvc.player;

import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.domaincomponent.domain.Tile;
import org.itson.events.PlayerEvents;
import org.itson.events.TileEvents;
import org.itson.game.MatchGame;
import org.itson.interfaces.TileObserver;
import org.itson.mvc.tile.TileComponent;
import org.itson.interfaces.MatchObserver;

/**
 *
 * @author santi
 */
public class PlayerController extends MouseAdapter implements TileObserver {

    private PlayerModel playerModel;

    private PlayerView playerView;

    private List<MatchObserver> observers = new ArrayList<>();

    public PlayerController(PlayerModel playerModel, PlayerView playerView) {
        this.playerModel = playerModel;
        this.playerView = playerView;

    }

    public void suscribeToView(MatchGame match) {
        this.addObserver(match);
    }

    
    public void addTileToPlayerList(TileComponent tile) {
        this.playerModel.addTile(tile);
        this.refreshPlayerView();
        unsuscribeOfTiles();
        suscribeToTiles();
    }

    public Boolean getTurn() {
        return this.playerModel.getPlayer().isTurn();
    }

    public TileComponent getTileFromList(TileComponent tile) {
        return this.playerModel.removeTile(tile);
    }

      public void suscribeToTiles() {
        for (TileComponent tilesComponents : this.playerModel.getTiles()) {
            // Verificar si ya está suscrito antes de suscribir
            if (!tilesComponents.isSubscribed(this)) {
                tilesComponents.suscribe(this);
            }
        }
    }

    public void unsuscribeOfTiles() {
        for (TileComponent tilesComponents : this.playerModel.getTiles()) {
            // Verificar si está suscrito antes de intentar desuscribir
            if (tilesComponents.isSubscribed(this)) {
                tilesComponents.unsuscribe(this);
            }
        }
    }


    public void refreshPlayerView() {
        playerView.refresh();
    }

    public void addObserver(MatchObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(MatchObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(PlayerEvents message) {
        for (MatchObserver observer : observers) {
            observer.eventOnPlayerUpdate(message);
        }
    }

    public void notifyObserversWithTile(PlayerEvents message, TileComponent tile) {
        for (MatchObserver observer : observers) {
            observer.eventOnPlayerClickedTile(message, tile);
        }
    }

    public TileComponent getTileComponentWithTileId(Tile tile) {
        for (TileComponent tileComponents : playerModel.getTiles()) {
            if (tileComponents.getTile().getId().equals(tile.getId())) {
                return tileComponents;
            }
        }
        return null;
    }

    @Override
    public void eventOnTileUpdate(TileEvents evt, Tile tile) {
        if (TileEvents.LEFT_CLICK_ON_TILE_EVENT.equals(evt)) {
            System.out.println("Calling matchgame");
            TileComponent comparedTile = getTileComponentWithTileId(tile);
            notifyObserversWithTile(PlayerEvents.LEFT_CLICK_ON_PLAYER_EVENT, comparedTile );
        }
    }

}
