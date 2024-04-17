package org.itson.mvc.tile;

import org.itson.domaincomponent.domain.Tile;
import org.itson.interfaces.TileObserver;
import org.itson.mvc.player.PlayerController;

public class TileComponent {

    TileView tileView;
    TileModel tileModel;
    TileController tileController;

    public TileComponent(Tile tile) {
        this.tileModel = new TileModel(tile);
        this.tileView = new TileView(tileModel);
        this.tileController = new TileController(tileModel, tileView);

    }

    public void suscribe(PlayerController player) {
        this.tileController.suscribe(player);
    }

    public void unsuscribe(PlayerController player) {
        this.tileController.unsuscribe(player);
    }

    public void refresh() {
        this.tileController.refresh();
    }

    public Tile getTile() {
        return this.tileController.getTile();
    }

    public boolean isSubscribed(TileObserver observer) {
        return tileController.isSubscribed(observer);
    }

    public TileView getTileView() {
        return tileView;
    }

    public TileModel getTileModel() {
        return tileModel;
    }

    public TileController getTileController() {
        return tileController;
    }

}
