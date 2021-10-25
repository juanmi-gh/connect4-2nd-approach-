package connect4.views;

import connect4.types.Error;
import utils.views.WithConsoleView;

public class ErrorView extends WithConsoleView {

    public static final String[] MESSAGES = {
        "The square is not empty",
        "There is not a token of yours", 
        "The origin and target squares are the same",
        "Wrong number of users",
        "The coordinates are wrong" };

    protected Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    void writeln() {
        console.writeln(ErrorView.MESSAGES[error.ordinal()]);
    }

}
