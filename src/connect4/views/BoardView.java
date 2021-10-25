package connect4.views;

import static connect4.views.MessageView.*;

import connect4.controllers.PlayController;
import connect4.models.Coordinate;
import utils.views.WithConsoleView;

class BoardView extends WithConsoleView {
    
    private final PlayController playController;

    BoardView(PlayController playController) {
        super();
        this.playController = playController;
    }

    void write() {
        console.writeln(SEPARATOR.getMessage());
        for (int i = 0; i < playController.getCoordinateDimension(); i++) {
            printRowBoard(i);
        }
        console.writeln(SEPARATOR.getMessage());
    }

    private void printRowBoard(int row) {
        console.write(VERTICAL_LINE_LEFT.getMessage());
        
        for (int j = 0; j < playController.getCoordinateDimension(); j++) {
            printSquareBoard(new Coordinate(row, j));
        }
        console.writeln();
    }

    private void printSquareBoard(Coordinate coordinate) {

        if (playController.isEmptyToken(coordinate)) {
            console.write(EMPTY.getMessage());
        
        } else {
            console.write(playController.getTokenChar(coordinate));
        }
        
        console.write(VERTICAL_LINE_CENTERED.getMessage());
    }
}
