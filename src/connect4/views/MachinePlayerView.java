package connect4.views;

import connect4.controllers.PlayController;
import connect4.models.Coordinate;
import connect4.types.Error;

class MachinePlayerView extends PlayerView {

    MachinePlayerView(PlayController playController) {
        super(playController);
    }

    @Override
    public Coordinate readCoordinateToPut() {
        
        Coordinate coordinate;
        Error error;
        
        do {
            coordinate = playController.generateRandomCoordinate();
            error = getPutCoordinateError(coordinate);
        } while (error != null);
        
        return coordinate;
    }

    @Override
    public Coordinate[] readCoordinatesToMove() {
        Coordinate[] coordinates = new Coordinate[2];
        Error error;
        
        do {
            coordinates[0] = playController.generateRandomCoordinate();
            error = getMoveOriginCoordinateError(coordinates[0]);
        } while (error != null);
        do {
            coordinates[1] = playController.generateRandomCoordinate();
            error = getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
        } while (error != null);
        
        return coordinates;
    }

}
