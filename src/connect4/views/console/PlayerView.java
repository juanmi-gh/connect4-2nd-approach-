package connect4.views.console;

import static connect4.views.Message.*;

import connect4.models.Player;

public class PlayerView implements connect4.views.PlayerView {

    private Player player;
    
    PlayerView(Player player) {
        this.player = player;
    }
    
    public void writeWinner() {
        new MessageView().writeln(PLAYER_WIN, player.getColor().name());
    }

}