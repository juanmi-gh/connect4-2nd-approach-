package connect4.views;

import static connect4.views.MessageView.*;

import connect4.controllers.PlayController;

class UndoCommand extends Command {

    UndoCommand(PlayController playController) {
        super(UNDO_COMMAND.getMessage(), playController);
    }

    protected void execute() {
        playController.undo();
        new GameView(playController);
    }
    
    protected boolean isActive() {
        return playController.undoable();
    }
    
}
