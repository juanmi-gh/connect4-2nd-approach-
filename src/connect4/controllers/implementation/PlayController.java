package connect4.controllers.implementation;

import connect4.controllers.MovementController;
import connect4.controllers.RedoController;
import connect4.controllers.UndoController;
import connect4.models.Coordinate;
import connect4.models.Session;
import connect4.types.PlayerType;
import connect4.types.Error;

public class PlayController extends connect4.controllers.PlayController {

    private final MovementController movementController;
    private final UndoController undoController;
    private final RedoController redoController;

    public PlayController(Session session) {
        super(session);
        movementController = new MovementController(session);
        undoController = new UndoController(session);
        redoController = new RedoController(session);
    }

    @Override
    public void undo() {
        undoController.undo();
    }

    @Override
    public void redo() {
        redoController.redo();
    }

    @Override
    public boolean undoable() {
        return undoController.undoable();
    }

    @Override
    public boolean redoable() {
        return redoController.redoable();
    }

    @Override
    public PlayerType getTypeOfTokenPlayerFromTurn() {
        return movementController.getTypeOfTokenPlayerFromTurn();
    }

    @Override
    public Error getPutCoordinateError(Coordinate coordinate) {
        return movementController.getPutCoordinateError(coordinate);
    }

    @Override
    public Error getMoveOriginCoordinateError(Coordinate coordinate) {
        return movementController.getMoveOriginCoordinateError(coordinate);
    }

    @Override
    public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        return movementController.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
    }

    @Override
    public boolean isCoordinateValid(Coordinate coordinate) {
        return movementController.isCoordinateValid(coordinate);
    }

    @Override
    public Coordinate generateRandomCoordinate() {
        return movementController.generateRandomCoordinate();
    }

    @Override
    public boolean isBoardComplete() {
        return movementController.isBoardComplete();
    }

    @Override
    public void putTokenPlayerFromTurn(Coordinate coordinate) {
        movementController.putTokenPlayerFromTurn(coordinate);
    }

    @Override
    public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
        movementController.moveTokenPlayerFromTurn(coordinates);
    }

    @Override
    public void changeTurn() {
        movementController.changeTurn();
    }

    @Override
    public char getTokenChar(Coordinate coordinate) {
        return movementController.getTokenChar(coordinate);
    }

    @Override
    public boolean isEmptyToken(Coordinate coordinate) {
        return movementController.isEmptyToken(coordinate);
    }

    @Override
    public int getValueFromTurn() {
        return movementController.getValueFromTurn();
    }

    @Override
    public int getCoordinateDimension() {
        return Coordinate.DIMENSION;
    }

    @Override
    public void continueState() {
        movementController.continueState();
    }

    @Override
    public boolean isTicTacToe() {
        return movementController.isTicTacToe();
    }

}
