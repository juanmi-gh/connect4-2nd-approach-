package connect4.views;

import static connect4.types.PlayerType.*;

import connect4.controllers.PlayController;
import connect4.models.Coordinate;


public class MovementCommand extends Command {

    MovementCommand(PlayController playController) {
        super(MessageView.PROPOSE_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        new BoardView(playController).write();
        
        PlayerView playerView = playController.getTypeOfTokenPlayerFromTurn() == USER_PLAYER
                ? new UserPlayerView(playController)
                : new MachinePlayerView(playController);
                
        if (!playController.isBoardComplete()) {
            Coordinate coordinate = playerView.readCoordinateToPut();
            playController.putTokenPlayerFromTurn(coordinate);

        } else {
            Coordinate[] coordinates = playerView.readCoordinatesToMove();
            playController.moveTokenPlayerFromTurn(coordinates);
        }
        
        new GameView(playController);
    }

    @Override
    protected boolean isActive() {
        return true;
    }
    
}
