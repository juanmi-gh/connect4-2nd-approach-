package connect4;

import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;
import connect4.models.Game;
import connect4.views.ViewFactory;

abstract class Connect4 {

    private final Game game;
    private final ViewFactory viewFactory;

    private final StartController startController;
    private final PlayController playController;
    private final ResumeController resumeController;

    protected Connect4() {
        game = new Game();
        viewFactory = createViewFactory();

        startController = new StartController(game, viewFactory);
        playController = new PlayController(game, viewFactory);
        resumeController = new ResumeController(game, viewFactory);
    }

    protected abstract ViewFactory createViewFactory();

    protected void play() {

        do {
            startController.control();
            
            playController.control();
        
        } while (resumeController.control());
    }

}
