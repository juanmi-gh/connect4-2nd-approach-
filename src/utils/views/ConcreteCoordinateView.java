package utils.views;

import static utils.models.ConcreteCoordinate.*;

import utils.models.ConcreteCoordinate;

public class ConcreteCoordinateView {

    public ConcreteCoordinate read(String title) {

        Console console = Console.getInstance();
        console.writeln(title);
        
        int row = console.readInt(ROW) - 1;
        int column = console.readInt(COLUMN) - 1;

        return new ConcreteCoordinate(row, column);
    }

}
