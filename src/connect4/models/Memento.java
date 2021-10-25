package connect4.models;

public class Memento {

    private Board board;
    private Player[] players;
    private Turn turn;

    Memento(Board board, Player[] players, Turn turn) {
        board = board.copy();
        this.players = players;
        turn = turn.copy(this.players);
    }
    
    Board getBoard() {
        return this.board;
    }

    Player[] getPlayers() {
        return this.players;
    }

    Turn getTurn() {
        return this.turn;
    }
    
}
