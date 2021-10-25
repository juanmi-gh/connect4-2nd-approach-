package connect4.controllers;

import connect4.models.Session;
import connect4.types.StateValue;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public StateValue getValueState() {
        return session.getValueState();
    }
}