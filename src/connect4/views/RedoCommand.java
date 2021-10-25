package connect4.views;

import static connect4.views.MessageView.*;
import connect4.controllers.PlayController;

class RedoCommand extends Command{
    
    RedoCommand(PlayController playController) {
        super(REDO_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        playController.redo();
        new GameView(playController);
        
    }

    @Override
    protected boolean isActive() {
        return playController.redoable();
    }

}
