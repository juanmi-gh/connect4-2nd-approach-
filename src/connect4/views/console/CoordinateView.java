package connect4.views.console;

import static connect4.views.ErrorView.*;

import connect4.types.Coordinate;
import connect4.types.Error;
import utils.models.ConcreteCoordinate;
import utils.models.SquareBoundedCoordinate;
import utils.views.SquareBoundedCoordinateView;

public class CoordinateView extends SquareBoundedCoordinateView implements connect4.views.CoordinateView {

    @Override
    public SquareBoundedCoordinate createCoordinate(ConcreteCoordinate concreteCoordinate) {
        return new Coordinate(concreteCoordinate);
    }

    @Override
    public String getErrorMessage() {
        return MESSAGES[Error.WRONG_COORDINATES.ordinal()];
    }

}