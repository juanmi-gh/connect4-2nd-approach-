package connect4.views;

import connect4.controllers.PlayController;

abstract class Command extends utils.models.Command {

    protected PlayController playController;

    protected Command(String title, PlayController playController) {
        super(title);
        this.playController = playController;
    }
    
}