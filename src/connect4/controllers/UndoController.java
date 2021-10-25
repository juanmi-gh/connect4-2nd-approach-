package connect4.controllers;

import connect4.models.GameSession;
import connect4.models.Session;

public class UndoController extends Controller {

    private GameSession sessionImplementation;

    public UndoController(Session session) {
        super(session);
        sessionImplementation = ((GameSession) this.session);
    }

    public void undo() {
        sessionImplementation.undo();
    }

    public boolean undoable() {
        return sessionImplementation.undoable();
    }
    
}
