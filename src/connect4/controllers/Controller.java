package connect4.controllers;

import static connect4.types.Coordinate.*;

import connect4.models.Game;
import connect4.types.Coordinate;
import connect4.views.BoardView;
import connect4.views.ViewFactory;

public abstract class Controller {

    protected Game game;
    protected ViewFactory viewFactory;

    Controller(Game game, ViewFactory viewFactory) {
        this.game = game;
        this.viewFactory = viewFactory;
    }

    void writeBoard() {
        BoardView boardView = this.viewFactory.createBoardView();
        
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                boardView.set(game.getColor(new Coordinate(i, j)));
            }
        }
        boardView.write();
    }

}