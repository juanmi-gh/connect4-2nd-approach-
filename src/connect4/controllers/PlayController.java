package connect4.controllers;

import connect4.models.Game;
import connect4.types.Coordinate;
import connect4.views.Message;
import connect4.views.ViewFactory;

public class PlayController extends Controller {

    public PlayController(Game game, ViewFactory viewFactory) {
        super(game, viewFactory);
    }

    public void control() {

        do {
            getActionController().run();
            game.next();
            viewFactory.createBoardView(game.getBoard()).write();
        
        } while (!game.isTicTacToe());

        viewFactory.createPlayerView(game.getActivePlayer()).writeWinner();
    }
        
    protected Coordinate getCoordinate(Message message) {
        assert message != null;

        return (Coordinate) viewFactory.createCoordinateView().read(message.toString());
    }

    private ActionController getActionController() {
        
        if (game.areAllTokensOnBoard()) {
            return new MoveController(game, viewFactory);
        
        } else {
            return new PutController(game, viewFactory);
        }
    }

}
