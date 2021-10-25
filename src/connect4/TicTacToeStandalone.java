package connect4;

import connect4.controllers.Logic;
import connect4.controllers.implementation.GameLogic;

public class TicTacToeStandalone extends Connect4 {

    @Override
    protected Logic createLogic() {
        return new GameLogic();
    }
    
    public static void main(String[] args) {
        new TicTacToeStandalone().play();
    }
    
}