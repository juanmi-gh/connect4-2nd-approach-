package connect4.controllers;

import connect4.models.Game;
import connect4.views.ViewFactory;

public class ResumeController extends Controller {

    public ResumeController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public boolean control() {
        
        boolean isResumed = viewFactory.createResumeView().read();
        if (isResumed) {
            this.game.reset();
        }
        
        return isResumed;
    }

}
