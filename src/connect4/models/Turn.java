package connect4.models;

import connect4.types.Color;
import connect4.types.Coordinate;
import connect4.types.Error;

public class Turn {

    private Board board;
    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;

    Turn(Board board) {
        assert board != null;
        
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
        
        reset();
    }

    void reset() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            players[i] = new Player(Color.get(i), board);
        }
        activePlayer = 0;
    }

    void next() {
        if (!board.isTicTacToe(getActiveColor())) {
            activePlayer = (activePlayer + 1) % NUMBER_PLAYERS;
        }
    }

    Player getActivePlayer() {
        return players[activePlayer];
    }

    Color getActiveColor() {
        return getActivePlayer().getColor();
    }

    boolean areAllTokensOnBoard() {
        return getActivePlayer().areAllTokensOnBoard();
    }

    void putToken(Coordinate coordinate) {
        getActivePlayer().putToken(coordinate);
    }

    Error getPutTokenError(Coordinate coordinate) {
        return getActivePlayer().getPutTokenError(coordinate);
    }

    void moveToken(Coordinate origin, Coordinate target) {
        getActivePlayer().moveToken(origin, target);
    }

    Error getOriginMoveTokenError(Coordinate coordinate) {
        return getActivePlayer().getOriginMoveTokenError(coordinate);
    }

    Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return getActivePlayer().getTargetMoveTokenError(origin, target);
    }

}