package connect4;

import connect4.controllers.AcceptorController;
import connect4.controllers.Logic;
import connect4.views.View;

abstract class Connect4 {

    private Logic logic;

    private View view;

    protected Connect4() {
        logic = this.createLogic();
        view = new View();
    }
    
    protected abstract Logic createLogic();

    protected void play() {
        
        AcceptorController acceptorController;
        
        do {
            acceptorController = logic.getController();
            if (acceptorController != null){
                view.interact(acceptorController);
            }
        } while (acceptorController != null);
    }

}
