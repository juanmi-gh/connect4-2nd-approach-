package connect4.controllers;

import connect4.models.Game;
import connect4.views.ViewFactory;

public abstract class Controller {

    protected Game game;
    protected ViewFactory viewFactory;

    Controller(Game game, ViewFactory viewFactory) {
        this.game = game;
        this.viewFactory = viewFactory;
    }
}