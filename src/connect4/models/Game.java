package connect4.models;

import connect4.types.Color;
import connect4.types.Coordinate;
import connect4.types.Error;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        board = new Board();
        turn = new Turn(this.board);
    }

    public void reset() {
        board.reset();
        turn.reset();
    }

    public void next() {
        turn.next();
    }

    public Color getActiveColor() {
        return turn.getActiveColor();
    }

    public boolean isTicTacToe() {
        return board.isTicTacToe(turn.getActiveColor());
    }

    public Color getColor(Coordinate coordinate) {
        return board.getColor(coordinate);
    }

    public boolean areAllTokensOnBoard() {
        return turn.areAllTokensOnBoard();
    }

    public void putToken(Coordinate coordinate) {
        turn.putToken(coordinate);
    }

    public Error getPutTokenError(Coordinate coordinate) {
        return turn.getPutTokenError(coordinate);
    }

    public void moveToken(Coordinate origin, Coordinate target) {
        turn.moveToken(origin, target);
    }

    public Error getOriginMoveTokenError(Coordinate coordinate) {
        return turn.getOriginMoveTokenError(coordinate);
    }

    public Error getTargetMoveTokenError(Coordinate origin, Coordinate target) {
        return turn.getTargetMoveTokenError(origin, target);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (board == null) {
            if (other.board != null)
                return false;
        } else if (!board.equals(other.board))
            return false;
        if (turn == null) {
            return other.turn == null;
        } else return turn.equals(other.turn);
    }

}