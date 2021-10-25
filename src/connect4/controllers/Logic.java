package connect4.controllers;

import java.util.EnumMap;
import java.util.Map;

import connect4.models.Session;
import connect4.types.StateValue;

public class Logic {

    protected Session session;
    protected Map<StateValue, AcceptorController> acceptorControllers;

    protected Logic() {
        acceptorControllers = new EnumMap<>(StateValue.class);
    }
    
    public AcceptorController getController() {
        return acceptorControllers.get(session.getValueState());
    }
    
}
