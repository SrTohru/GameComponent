package org.itson.mvc.Match;

import org.itson.domaincomponent.domain.Board;
import org.itson.domaincomponent.domain.Match;
import org.itson.domaincomponent.domain.Player;
import org.itson.domaincomponent.domain.Pool;
import org.itson.domaincomponent.exceptions.PoolException;
import org.itson.mvc.Pool.PoolComponent;
import org.itson.mvc.board.BoardComponent;
import org.itson.mvc.player.PlayerComponent;
import org.itson.game.MatchGame;
import org.itson.mvc.tile.TileComponent;

public class MatchComponent {

    private MatchModel matchModel;
    private MatchView matchView;
    private MatchController matchController;

    private PoolComponent poolComponent;
    private PlayerComponent playerComponent;
    private BoardComponent boardComponent;
    private TileComponent tileComponent;

    public MatchComponent() {
        this.matchModel = new MatchModel(new Match(new Player[4], Board.getInstance(), Pool.getInstance(), 7), Board.getInstance(), Pool.getInstance(), new Player[4]);
        this.matchView = new MatchView(matchModel);
        this.matchController = new MatchController(matchModel, matchView);
        this.poolComponent = new PoolComponent();
        this.playerComponent = new PlayerComponent();
        this.boardComponent = new BoardComponent();
    }

    /*
        Suscribe methods 
 
    -----------------------------------------------------------------------------
     */
    public void suscribeToPool(MatchGame match) {
        this.poolComponent.suscribeToView(match);
    }

    public void suscribeToBoard(MatchGame match) {
        this.boardComponent.suscribe(match);
    }

    public void suscribeToPlayer(MatchGame match) {
        this.playerComponent.suscribeToView(match);

    }
    /*
    -----------------------------------------------------------------------------
     */
    
    
    public Player[] getPlayersOnGame() {
        return matchController.getPlayersOnGame();
    }

    public TileComponent getTileFromPool() throws PoolException {
        return this.poolComponent.getController().getTileFromPool();
    }

    public void addTileToPlayer(TileComponent tile) {
        this.playerComponent.addTileToPlayerList(tile);
    }

    public void addTileToBoard(TileComponent tile) {
        this.boardComponent.addTileToBoard(tile);
    }

    public void createDominoTiles() throws PoolException {
        this.poolComponent.createDominoTiles();
    }

    public Boolean getTurn() {
        return this.playerComponent.getTurn();
    }

    public TileComponent getTileSelected(TileComponent tile) {
        return this.playerComponent.getTileFromList(tile);
    }

    public PoolComponent getPoolComponent() {
        return poolComponent;
    }

    public PlayerComponent getPlayerComponent() {
        return playerComponent;
    }

    public BoardComponent getBoardComponent() {
        return boardComponent;
    }

    public TileComponent getTileComponent() {
        return tileComponent;
    }

    public void paintBoard() {
        this.boardComponent.refreshBoard();
    }

    public void paintPool() {
        this.poolComponent.refresh();
    }

    public void paintPlayer() {
        this.playerComponent.refreshPlayer();
    }

    public void buildGame() throws PoolException {

        this.poolComponent.createDominoTiles();
        this.matchController.buildGame();

    }

    public MatchView getMatchView() {
        return matchView;
    }

    public int getTilesSize() {
        return this.matchModel.getListOfTilesSize();
    }

}
