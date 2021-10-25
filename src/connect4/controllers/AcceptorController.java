package connect4.controllers;

import connect4.models.Session;

public abstract class AcceptorController extends Controller {
    
    AcceptorController(Session session) {
        super(session);
    }

    public abstract void accept(ControllersVisitor controllersVisitor);
}
