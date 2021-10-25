package connect4.controllers.implementation;

import connect4.models.GameSession;
import connect4.models.Session;

public class ResumeController extends connect4.controllers.ResumeController {

    private GameSession gameSession;

    public ResumeController(Session session) {
        super(session);
        gameSession = ((GameSession) this.session);
    }

    public void resume(boolean newGame) {
        if (newGame) {
            gameSession.newGame();
        
        } else {
            gameSession.next();
        }
    }

}
