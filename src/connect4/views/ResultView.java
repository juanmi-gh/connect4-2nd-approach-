package connect4.views;

import static connect4.views.MessageView.*;

import connect4.types.Token;
import utils.views.WithConsoleView;

class ResultView extends WithConsoleView {

    void writeln(int winner) {
        console.write(Token.values()[winner].getChar());
        console.writeln(PLAYER_WIN.getMessage());
    }
}
