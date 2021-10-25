package connect4.models;


import static connect4.types.Error.*;

import connect4.types.Error;
import connect4.types.PlayerType;
import connect4.types.Token;

public class Player {

    private Token token;
    private Board board;
    private PlayerType type;

    public Player(Token token, Board board, PlayerType type) {
        this.token = token;
        this.board = board;
        this.type = type;
    }

    public PlayerType getType() {
        return type;
    }

    void put(Coordinate coordinate) {
        board.put(coordinate, this.token);
    };

    void move(Coordinate[] coordinates) {
        board.move(coordinates[0], coordinates[1]);
    };

    Token getToken() {
        return token;
    }

    public Error getPutCoordinateError(Coordinate coordinate) {
        
        return board.isEmpty(coordinate) ? null : NOT_OWNER;
    }

    public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
        
        return board.isOccupied(originCoordinate, token) ? null : NOT_OWNER;
    }

    public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        
        return originCoordinate.equals(targetCoordinate) ? SAME_COORDINATES : isEmpty(targetCoordinate);
    }
    
    private Error isEmpty(Coordinate coordinate) {
        return board.isEmpty(coordinate) ? null : NOT_EMPTY;
    }

}
