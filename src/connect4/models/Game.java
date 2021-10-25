package connect4.models;

import static connect4.models.Turn.*;
import static connect4.types.Error.*;

import connect4.types.Error;
import connect4.types.PlayerType;
import connect4.types.Token;

public class Game {

    private Board board;
    private Turn turn;
    private Player[] players;

    public Game() {
        newGame();
    }

    public void newGame() {
        board = new Board();
        players = new Player[NUM_PLAYERS];
        turn = new Turn(players);
    }
    
    public void createPlayers(int numberOfUsers) {

        for (int i = 0; i < numberOfUsers; i++) {
            players[i] = new Player(Token.values()[i], board, PlayerType.USER_PLAYER);
        }
        
        for (int i = numberOfUsers; i < NUM_PLAYERS; i++) {
            players[i] = new Player(Token.values()[i], board, PlayerType.MACHINE_PLAYER);
        }
    }

    Memento createMemento() {
        Board board = this.board.copy();
        return new Memento(board, createCopyOfPlayers(players, board), turn);
    }

    void set(Memento memento) {
        board = memento.getBoard().copy();
        players = createCopyOfPlayers(memento.getPlayers(), board);
        turn = memento.getTurn().copy(players);
    }

    private Player[] createCopyOfPlayers(Player[] players, Board board) {
        Player[] playersCopy = new Player[2];
        for (int i = 0; i < NUM_PLAYERS; i++) {
            playersCopy[i] = new Player(players[i].getToken(), board, players[i].getType());
        }
        return playersCopy;
    }

    public boolean isBoardComplete() {
        return board.isCompleted();
    }

    public void putTokenPlayerFromTurn(Coordinate coordinate) {
        turn.getPlayer().put(coordinate);
    }

    public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
        turn.getPlayer().move(coordinates);
    }

    public PlayerType getTypeOfTokenPlayerFromTurn() {
        return turn.getPlayer().getType();
    }

    public Error getPutCoordinateError(Coordinate coordinate) {
        return board.isEmpty(coordinate) ? null : NOT_OWNER;
    }

    public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
        return board.isOccupied(originCoordinate, turn.getPlayer().getToken()) ? null : NOT_OWNER;
    }

    public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        return originCoordinate.equals(targetCoordinate) ? SAME_COORDINATES : isEmpty(targetCoordinate);
    }
    
    private Error isEmpty(Coordinate coordinate) {
        return board.isEmpty(coordinate) ? null : NOT_EMPTY;
    }

    public Token getToken(Coordinate coordinate) {
        return board.getToken(coordinate);
    }

    public void changeTurn() {
        turn.change();
    }

    public boolean isTicTacToe() {
        return board.isTicTacToe(turn.getOtherPlayer().getToken());
    }

    public int getValueFromTurn() {
        return turn.getValue();
    }


}