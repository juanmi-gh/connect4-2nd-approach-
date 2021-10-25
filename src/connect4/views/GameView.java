package connect4.views;

import connect4.controllers.PlayController;

public class GameView {

    GameView(PlayController playController) {

        new BoardView(playController).write();
        
        if (playController.isTicTacToe()) {
            new ResultView().writeln(playController.getValueFromTurn());
            playController.continueState();
        }
    }
    
}
