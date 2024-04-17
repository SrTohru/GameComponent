package org.itson.mvc.Pool;

import org.itson.domaincomponent.exceptions.PoolException;
import org.itson.game.MatchGame;
import org.itson.mvc.tile.TileComponent;

public class PoolComponent {

    private static PoolComponent poolComponent;
    PoolModel poolModel;
    PoolView poolView;
    PoolController poolController;

    public PoolComponent() {
        this.poolModel = new PoolModel(120, 130, 1110, 260);
        this.poolView = new PoolView(poolModel);
        this.poolController = new PoolController(poolView, poolModel);
    }
    
    public void suscribeToView(MatchGame match){
        this.poolController.suscribe(match);
    }
    
    public TileComponent getTileFromPool() throws PoolException{
        return this.poolController.getTileFromPool();
    }
    
    public void createDominoTiles() throws PoolException{
        this.poolController.createDominoTiles();
    }
    public PoolModel getModel() {
        return poolModel;
    }

    public PoolController getController() {
        return poolController;
    }

    
    public PoolView getView() {
        return poolView;
    }

    public void refresh(){
        this.poolController.refresh();
    }
    
    public static PoolComponent getInstance() {
        if (poolComponent == null) {
            poolComponent = new PoolComponent();
        }
        return poolComponent;
    }
}
