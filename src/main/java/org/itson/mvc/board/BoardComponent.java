package org.itson.mvc.board;

import org.itson.game.MatchGame;
import org.itson.mvc.tile.TileComponent;

public class BoardComponent {

    BoardController boardController;
    BoardModel boardModel;
    BoardView boardView;

    public BoardComponent() {
        boardModel = new BoardModel(730, 630, 0, 0);
        boardView = new BoardView(boardModel);
        boardController = new BoardController(boardView, boardModel);
    }

    public void suscribe(MatchGame match) {
        this.boardController.suscribe(match);
    }

    public void addTileToBoard(TileComponent tile) {
        this.boardController.addTileToBoard(tile);
    }

    public BoardModel getBoardModel() {
        return boardModel;
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public BoardView getBoardView() {
        return boardView;
    }

    public void refreshBoard() {
        this.boardView.refresh();
    }
}
