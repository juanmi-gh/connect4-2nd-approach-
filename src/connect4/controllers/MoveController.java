package connect4.controllers;

import static connect4.views.Message.COORDINATE_TO_MOVE;
import static connect4.views.Message.COORDINATE_TO_REMOVE;

import connect4.models.Game;
import connect4.types.Coordinate;
import connect4.types.Error;
import connect4.views.ViewFactory;

class MoveController extends PlayController implements ActionController {

    public MoveController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    @Override
    public void run() {
        Coordinate origin;
        Error error;
        do {
            origin = getCoordinate(COORDINATE_TO_REMOVE);
            error = getOriginMoveTokenError(origin);
        } while (!error.isNull());
        
        Coordinate target;
        do {
            target = getCoordinate(COORDINATE_TO_MOVE);
            error = getTargetMoveTokenError(origin, target);
        } while (!error.isNull());
        
        
        game.moveToken(origin, target);        
    }
    
    private Error getOriginMoveTokenError(Coordinate origin) {
        assert !origin.isNull();

        Error error = game.getOriginMoveTokenError(origin);
        viewFactory.createErrorView().writeln(error);
        
        return error;
    }

    private Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !target.isNull();

        Error error = game.getTargetMoveTokenError(origin, target);
        viewFactory.createErrorView().writeln(error);
        
        return error;
    }

   

    
}
