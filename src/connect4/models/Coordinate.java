package connect4.models;

import java.util.Random;

import utils.models.Direction;

public class Coordinate extends utils.models.Coordinate {

    public static final int DIMENSION = 3;

    public Coordinate() {
        super();
    }

    public Coordinate(int row, int column) {
        super(row, column);
    }

    boolean inDirection(Coordinate coordinate) {
        return getDirection(coordinate) != null;
    }

    Direction getDirection(Coordinate coordinate) {
        
        Direction direction = super.getDirection(coordinate);
        if (direction != null) {
            return direction;
        }
        if (this.inInverseDiagonal() && coordinate.inInverseDiagonal()) {
            return Direction.INVERSE_DIAGONAL;
        }
        
        return null;
    }

    private boolean inInverseDiagonal() {
        return row + column == DIMENSION - 1;
    }

    public boolean isValid() {
        return row >= 0 
                && row < DIMENSION 
                && column >= 0
                && column < DIMENSION;
    }

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        row = random.nextInt(DIMENSION);
        column = random.nextInt(DIMENSION);
    }

}
