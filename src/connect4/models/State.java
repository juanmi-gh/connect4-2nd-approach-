package connect4.models;

import connect4.types.StateValue;

public class State {

    private StateValue stateValue;
    
    public State() {
        stateValue = StateValue.INITIAL;
    }
    
    public void next() {
        stateValue = StateValue.values()[stateValue.ordinal()+1];
    }

    public void reset() {
        stateValue = StateValue.INITIAL;
    }

    public StateValue getValueState() {
        return stateValue;
    }
    
}
