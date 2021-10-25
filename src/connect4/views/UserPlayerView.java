package connect4.views;

import connect4.types.Error;
import connect4.controllers.PlayController;
import connect4.models.Coordinate;

class UserPlayerView extends PlayerView {
    static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
    static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

    UserPlayerView(PlayController playController) {
        super(playController);
    }

    @Override
    public Coordinate readCoordinateToPut() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = new CoordinateView(playController).read(ENTER_COORDINATE_TO_PUT);
            error = getPutCoordinateError(coordinate);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        
        return coordinate;
    }

    @Override
    public Coordinate[] readCoordinatesToMove() {
        Coordinate[] coordinates = new Coordinate[2];
        Error error;
        do {
            coordinates[0] = new CoordinateView(playController).read(ENTER_COORDINATE_TO_REMOVE);
            error = getMoveOriginCoordinateError(coordinates[0]);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        
       do {
            coordinates[1] = new CoordinateView(playController).read(ENTER_COORDINATE_TO_PUT);
            error = getMoveTargetCoordinateError(coordinates[0], coordinates[1]);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        return coordinates;
    }
}
