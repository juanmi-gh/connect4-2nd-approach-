package connect4.models;

import static connect4.models.Turn.*;
import static connect4.models.Coordinate.*;

import connect4.types.Token;
import utils.models.Direction;

public class Board {

    static final char EMPTY = '-';

    private Coordinate[][] coordinates;

    public Board() {
        coordinates = new Coordinate[NUM_PLAYERS][DIMENSION];
        for (int i = 0; i < NUM_PLAYERS; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                coordinates[i][j] = null;
            }
        }
    }

    public Board(Coordinate[][] coordinates) {
        this.coordinates = coordinates;
    }

    public Token getToken(Coordinate coordinate) {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (coordinates[i][j] != null 
                        && coordinates[i][j].getRow() == coordinate.getRow()
                        && coordinates[i][j].getColumn() == coordinate.getColumn()) {
                    return Token.values()[i];
                }
            }
        }
        return null;
    }

    void move(Coordinate originCoordinate, Coordinate coordinate) {
        assert !isEmpty(originCoordinate);
        assert isEmpty(coordinate);
        
        Token token = getToken(originCoordinate);
        remove(originCoordinate);
        put(coordinate, token);
    }

    void put(Coordinate coordinate, Token token) {
        assert isEmpty(coordinate);
        
        int i = 0;
        while (coordinates[token.ordinal()][i] != null) {
            i++;
        }
        coordinates[token.ordinal()][i] = coordinate;
    }

    private void remove(Coordinate coordinate) {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (coordinates[i][j] != null 
                        && coordinates[i][j].getRow() == coordinate.getRow()
                        && coordinates[i][j].getColumn() == coordinate.getColumn()) {
                    coordinates[i][j] = null;
                }
            }
        }
    }

    boolean isTicTacToe(Token token) {
        Coordinate[] coordinates = this.coordinates[token.ordinal()];
        return checkNumberOfCoordinates(coordinates) 
                && checkDirectionOfFirstCoordinates(coordinates)
                && checkDirectionOfAllCoordinates(coordinates);
    }

    private boolean checkNumberOfCoordinates(Coordinate[] coordinates) {
        return numberOfCoordinates(coordinates) == DIMENSION;
    }

    private boolean checkDirectionOfFirstCoordinates(Coordinate[] coordinates) {
        return coordinates[0].inDirection(coordinates[1]);
    }

    private boolean checkDirectionOfAllCoordinates(Coordinate[] coordinates) {
        
        Direction direction = coordinates[0].getDirection(coordinates[1]);
        for (int i = 1; i < coordinates.length - 1; i++) {
            if (direction != coordinates[i].getDirection(coordinates[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private int numberOfCoordinates(Coordinate[] coordinates) {
        int count = 0;
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i] != null) {
                count++;
            }
        }
        return count;
    }

    boolean isCompleted() {
        for (int i = 0; i < NUM_PLAYERS; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (coordinates[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEmpty(Coordinate coordinate) {
        return isOccupied(coordinate, null);
    }

    boolean isOccupied(Coordinate coordinate, Token token) {
        return getToken(coordinate) == token;
    }

    Board copy() {

        Coordinate[][] coordinatesCopy = new Coordinate[NUM_PLAYERS][DIMENSION];
        for(int i = 0; i < NUM_PLAYERS; i++ ) {
            for(int j = 0; j < DIMENSION; j++ ) {
                coordinatesCopy[i][j] = coordinates[i][j];
            }
        }
        return new Board(coordinatesCopy);
    }

}