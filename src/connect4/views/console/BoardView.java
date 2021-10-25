package connect4.views.console;

import static connect4.types.Coordinate.*;
import static connect4.views.Message.*;

import connect4.models.Board;
import connect4.types.Coordinate;
import utils.views.Console;

public class BoardView implements connect4.views.BoardView {

    private Board board;

    BoardView(Board board) {
        this.board = board;
    }
    
    @Override
    public void write() {

        new MessageView().writeln(HORIZONTAL_LINE);

        for (int i = 0; i < DIMENSION; i++) {
            new MessageView().write(VERTICAL_LINE);
            
            for (int j = 0; j < DIMENSION; j++) {
                new ColorView().write(board.getColor(new Coordinate(i, j)));
                new MessageView().write(VERTICAL_LINE);
            }
            
            Console.getInstance().writeln();
        }
        
        new MessageView().writeln(HORIZONTAL_LINE);
    }

}
