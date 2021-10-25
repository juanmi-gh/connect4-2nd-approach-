package connect4.views;

import connect4.types.Error;
import connect4.controllers.PlayController;
import connect4.models.Coordinate;

public abstract class PlayerView {

    protected final PlayController playController;

    public PlayerView(PlayController playController) {
        this.playController = playController;
    }
  
    public Error getPutCoordinateError(Coordinate coordinate) {
        return playController.getPutCoordinateError(coordinate);
    }

    public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
        return playController.getMoveOriginCoordinateError(originCoordinate);
    }

    public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        return playController.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
    }
    
    public abstract Coordinate readCoordinateToPut();
    public abstract Coordinate[] readCoordinatesToMove();
}
