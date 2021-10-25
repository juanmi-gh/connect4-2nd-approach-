package connect4.controllers;

import static connect4.views.Message.ENTER_COORDINATE_TO_PUT;

import connect4.models.Game;
import connect4.types.Coordinate;
import connect4.types.Error;
import connect4.views.ViewFactory;

class PutController extends PlayController implements ActionController {

    public PutController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }
    
    @Override
    public void run() {
        Coordinate coordinate;
        Error error;
        do {
            coordinate = getCoordinate(ENTER_COORDINATE_TO_PUT);
            error = getPutTokenError(coordinate);
        
        } while (!error.isNull());
        
        game.putToken(coordinate);        
    }
    
    public Error getPutTokenError(Coordinate coordinate) {
        assert coordinate != null;

        Error error = game.getPutTokenError(coordinate);
        viewFactory.createErrorView().writeln(error);
        
        return error;
    }


}
