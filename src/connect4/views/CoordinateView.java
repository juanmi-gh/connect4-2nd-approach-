package connect4.views;

import static connect4.types.Error.*;
import static connect4.views.MessageView.*;

import connect4.controllers.PlayController;
import connect4.models.Coordinate;
import utils.views.WithConsoleView;

class CoordinateView extends WithConsoleView {

    final PlayController playController;

    CoordinateView(PlayController playController) {
        this.playController = playController;
    }

    Coordinate read(String title) {
        
        Coordinate coordinate;
        
        do {
            console.writeln(title);
            int row = console.readInt(READ_ROW.getMessage()) - 1;
            int column = console.readInt(READ_COLUMN.getMessage()) - 1;
            coordinate = new Coordinate(row, column);
            
            assert playController.isCoordinateValid(coordinate);
            
            if (!playController.isCoordinateValid(coordinate)) {
                new ErrorView(WRONG_COORDINATES).writeln();
            }
        } while (!this.playController.isCoordinateValid(coordinate));
        
        return coordinate;
    }
}
