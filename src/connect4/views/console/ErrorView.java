package connect4.views.console;

import connect4.types.Error;
import utils.views.Console;

public class ErrorView extends connect4.views.ErrorView {

    @Override
    public void writeln(Error error) {
        
        if (!error.isNull()) {
            Console.getInstance().writeln(MESSAGES[error.ordinal()]);
        }
    }
    
}