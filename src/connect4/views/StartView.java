package connect4.views;

import connect4.controllers.StartController;
import connect4.models.Turn;
import utils.models.PlayersDialog;
import utils.views.WithConsoleView;

class StartView extends WithConsoleView {

    void interact(StartController startController) {
        startController.start();
        
        console.writeln(MessageView.START_GAME.getMessage());
        int numberOfUsers = new PlayersDialog().read(Turn.NUM_PLAYERS);
        
        startController.createPlayers(numberOfUsers);
    }
}