package connect4.controllers;

import connect4.models.GameSession;
import connect4.models.Session;

public class RedoController extends Controller {

    private GameSession gameSession;

    public RedoController(Session session) {
        super(session);
        gameSession = ((GameSession) this.session);
    }

    public void redo() {
        gameSession.redo();
    }

    public boolean redoable() {
        return gameSession.redoable();
    }
    
}
