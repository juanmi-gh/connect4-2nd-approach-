package connect4.models;

import connect4.types.PlayerType;
import connect4.types.StateValue;
import connect4.types.Token;
import connect4.types.Error;

public class GameSession implements Session {

    private final State state;
    private final Game game;
    private final Registry registry;
    
    public GameSession() {
        state = new State();
        game = new Game();
        registry = new Registry(game);
    }

    public void next() {
        state.next();      
    }
    
    public boolean undoable() {
        return registry.undoable();
    }

    public boolean redoable() {
        return registry.redoable();
    }

    public void undo() {
        registry.undo(game);
    }

    public void redo() {
        registry.redo(game);
    }
    
    public void createPlayers(int numberOfUsers) {
        game.createPlayers(numberOfUsers);
        registry.registry();
    }

    public PlayerType getTypeOfTokenPlayerFromTurn() {
        return game.getTypeOfTokenPlayerFromTurn();
    }

    public Error getPutCoordinateError(Coordinate coordinate) {
        return game.getPutCoordinateError(coordinate);
    }

    public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
        return game.getMoveOriginCoordinateError(originCoordinate);
    }

    public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        return game.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
    }

    public boolean isBoardComplete() {
        return game.isBoardComplete();
    }

    public void putTokenPlayerFromTurn(Coordinate coordinate) {
        game.putTokenPlayerFromTurn(coordinate);
        game.changeTurn();
        registry.registry();
    }

    public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
        game.moveTokenPlayerFromTurn(coordinates);
        game.changeTurn();
        registry.registry();
    }

    public void changeTurn() {
        game.changeTurn();
    }

    public Token getToken(Coordinate coordinate) {
        return game.getToken(coordinate);
    }

    public boolean isTicTacToe() {
        return game.isTicTacToe();
    }

    public int getValueFromTurn() {
        return game.getValueFromTurn();
    }

    public StateValue getValueState() {
        return state.getValueState();
    }

    public void newGame() {
        game.newGame();
        state.reset(); 
        registry.reset();
    }
}
