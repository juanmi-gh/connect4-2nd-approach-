package connect4.models;

import static connect4.types.Coordinate.*;
import static connect4.types.Error.*;

import connect4.types.Color;
import connect4.types.Coordinate;
import connect4.types.Error;

public class Player {

    private Color color;
    private Board board;
    private int putTokens;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    boolean areAllTokensOnBoard() {
        return putTokens == DIMENSION;
    }

    void putToken(Coordinate coordinate) {
        assert putTokens < DIMENSION;

        board.putToken(coordinate, this.color);
        putTokens++;
    }

    Error getPutTokenError(Coordinate coordinate) {

        return board.isEmpty(coordinate) ? NULL : NOT_EMPTY;
    }

    void moveToken(Coordinate origin, Coordinate target) {
        board.moveToken(origin, target);
    }

    Error getOriginMoveTokenError(Coordinate origin) {
        return board.isOccupied(origin, color) ? NULL : NOT_OWNER;
    }

    Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return origin.equals(target) ? SAME_COORDINATES : getPutTokenError(target);
    }

    public Color getColor() {
        return color;
    }

}
