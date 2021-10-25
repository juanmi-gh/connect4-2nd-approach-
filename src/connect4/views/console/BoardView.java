package connect4.views.console;

import static connect4.types.Coordinate.*;
import static connect4.views.Message.*;

import utils.views.Console;

public class BoardView extends connect4.views.BoardView {

    @Override
    public void write() {

        new MessageView().writeln(HORIZONTAL_LINE);

        for (int i = 0; i < DIMENSION; i++) {
            new MessageView().write(VERTICAL_LINE);
            
            for (int j = 0; j < DIMENSION; j++) {
                new ColorView().write(colors.get(i * DIMENSION + j));
                new MessageView().write(VERTICAL_LINE);
            }
            
            Console.getInstance().writeln();
        }
        
        new MessageView().writeln(HORIZONTAL_LINE);
    }

}
