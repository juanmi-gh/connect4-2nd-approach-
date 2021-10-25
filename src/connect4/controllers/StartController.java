package connect4.controllers;

import connect4.models.Game;
import connect4.views.ViewFactory;

public class StartController extends Controller {

    public StartController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public void control() {
        viewFactory.createStartView().write();
        writeBoard();
    }

}