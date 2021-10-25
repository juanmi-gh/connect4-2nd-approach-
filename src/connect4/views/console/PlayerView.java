package connect4.views.console;

import static connect4.views.Message.*;

import connect4.types.Color;

public class PlayerView implements connect4.views.PlayerView {

    public void writeWinner(Color color) {
        new MessageView().writeln(PLAYER_WIN, color.name());
    }

}