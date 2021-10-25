package connect4.models;

import static connect4.types.Color.*;
import static connect4.types.Coordinate.*;

import java.util.ArrayList;
import java.util.List;

import connect4.types.Color;
import connect4.types.Coordinate;
import utils.models.Direction;

class Board {

    private Color[][] colors;

    Board() {
        colors = new Color[DIMENSION][DIMENSION];
        reset();
    }

    void reset() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                colors[i][j] = NULL;
            }
        }
    }

    void putToken(Coordinate coordinate, Color color) {
        assert !coordinate.isNull();

        colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    void moveToken(Coordinate origin, Coordinate target) {
        assert !origin.isNull() && !isEmpty(origin);
        assert !target.isNull() && isEmpty(target);
        assert !origin.equals(target);

        Color color = getColor(origin);
        putToken(origin, Color.NULL);
        putToken(target, color);
    }

    Color getColor(Coordinate coordinate) {
        assert !coordinate.isNull();

        return colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(Coordinate coordinate, Color color) {
        return getColor(coordinate) == color;
    }

    boolean isEmpty(Coordinate coordinate) {
        return isOccupied(coordinate, Color.NULL);
    }

    boolean isTicTacToe(Color color) {
        assert !color.isNull();

        List<Direction> directions = getDirections(color);
        if (directions.size() < DIMENSION - 1) {
            return false;
        }
        for (int i = 0; i < directions.size() - 1; i++) {
            if (directions.get(i) != directions.get(i + 1)) {
                return false;
            }
        }
        return !directions.get(0).isNull();
    }

    private List<Direction> getDirections(Color color) {
        assert !color.isNull();

        List<Direction> directions = new ArrayList<>();
        List<Coordinate> coordinates = getCoordinates(color);
        if (!coordinates.isEmpty()) {
            for (int i = 0; i < coordinates.size() - 1; i++) {
                directions.add(coordinates.get(i).getDirection(coordinates.get(i + 1)));
            }
        }
        return directions;
    }

    List<Coordinate> getCoordinates(Color color) {
        assert !color.isNull();

        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (getColor(new Coordinate(i, j)) == color) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
    }

}
