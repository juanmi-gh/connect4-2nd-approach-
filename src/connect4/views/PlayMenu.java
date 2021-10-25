package connect4.views;

import connect4.controllers.PlayController;
import utils.models.Menu;

public class PlayMenu extends Menu {

    PlayMenu(PlayController playController) {
        
        addCommand(new MovementCommand(playController));
        addCommand(new UndoCommand(playController));
        addCommand(new RedoCommand(playController));
    }
    
}
