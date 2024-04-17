package org.itson.mvc.player;

import org.itson.game.MatchGame;
import org.itson.mvc.tile.TileComponent;


public class PlayerComponent {
    
    PlayerView playerView;
    PlayerModel playerModel;
    PlayerController playerController;
    TileComponent tileComponent;
    
    public PlayerComponent() {
         this.playerModel = new PlayerModel(100, 50, 90, 550);
        this.playerView = new PlayerView(playerModel);
        this.playerController = new PlayerController(playerModel, playerView);
    }
    
    public void suscribeToView(MatchGame match){
        this.playerController.suscribeToView(match);
    }

    public void addTileToPlayerList(TileComponent tile){
        this.playerController.addTileToPlayerList(tile);
        this.playerController.suscribeToTiles();
    }
    
    public TileComponent getTileFromList(TileComponent tile){
        return this.playerController.getTileFromList(tile);
    }
    
    public void suscribeToTiles(){
        this.playerController.suscribeToTiles();
    }
    
    public void unsiscribeToTiles(){
        this.playerController.unsuscribeOfTiles();
    }
    
    public PlayerView getPlayerView() {
        return playerView;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }
    public PlayerController getPlayerController() {
        return playerController;
    }
    
    public boolean getTurn(){
        return this.playerController.getTurn();
    }
    
    public void refreshPlayer(){
        this.playerView.refresh();
    }
}