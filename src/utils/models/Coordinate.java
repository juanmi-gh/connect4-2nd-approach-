package utils.models;

public class Coordinate {
  
    protected int row;

    protected int column;

    protected Coordinate() {    }

    protected Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    protected Direction getDirection(Coordinate coordinate) {
        if (inHorizontal(coordinate)) {
            return Direction.HORIZONTAL;
        }
        if (inVertical(coordinate)) {
            return Direction.VERTICAL;
        }
        if (inMainDiagonal() && coordinate.inMainDiagonal()) {
            return Direction.MAIN_DIAGONAL;
        }
        
        return Direction.NULL;
    }

    private boolean inMainDiagonal() {
        return row == this.column;
    }

    private boolean inVertical(Coordinate coordinate) {
        return column == coordinate.column;
    }

    private boolean inHorizontal(Coordinate coordinate) {
        return row == coordinate.row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Coordinate coordinate) {
        return column == coordinate.column && row == coordinate.row;
    }
}
