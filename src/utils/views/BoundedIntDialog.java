package utils.views;

import utils.models.ClosedInterval;

public class BoundedIntDialog {

    private final ClosedInterval limits;

    private static final String ERROR_MESSAGE = "Invalid number";

    public BoundedIntDialog(int min, int max){
        limits = new ClosedInterval(min, max);
    }

    public int read(String message) {
        assert message != null;

        boolean ok;
        int value;
        do {
            value = Console.getInstance().readInt(message + "? " + limits + ": ");
            ok = limits.isIncluded(value);
            
            if (!ok) {
                Console.getInstance().writeln(ERROR_MESSAGE);
            }
        } while(!ok);
        
        return value;
    }
    
}
