package connect4.controllers;

import connect4.models.GameSession;
import connect4.models.Session;
import connect4.types.PlayerType;

import connect4.models.*;
import connect4.types.Error;

public class MovementController extends Controller {

    private GameSession gameSession;
    
    public MovementController(Session session) {
        super(session);
        gameSession = ((GameSession) super.session);
    }

    public PlayerType getTypeOfTokenPlayerFromTurn() {
        return gameSession.getTypeOfTokenPlayerFromTurn();
    }

    public Error getPutCoordinateError(Coordinate coordinate) {
        return gameSession.getPutCoordinateError(coordinate);
    }

    public Error getMoveOriginCoordinateError(Coordinate coordinate) {
        return gameSession.getMoveOriginCoordinateError(coordinate);
    }

    public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
        return gameSession.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
    }

    public boolean isCoordinateValid(Coordinate coordinate) {
        return coordinate.isValid();
    }

    public Coordinate generateRandomCoordinate() {
        Coordinate coordinateRandom = new Coordinate();
        coordinateRandom.random();
        return coordinateRandom;
    }

    public boolean isBoardComplete() {
        return gameSession.isBoardComplete();
    }

    public void putTokenPlayerFromTurn(Coordinate coordinate) {
        gameSession.putTokenPlayerFromTurn(coordinate);
    }

    public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
        gameSession.moveTokenPlayerFromTurn(coordinates);
    }

    public void changeTurn() {
        gameSession.changeTurn();
    }

    public char getTokenChar(Coordinate coordinate) {
        return gameSession.getToken(coordinate).getChar();
    }

    public boolean isEmptyToken(Coordinate coordinate) {
        return gameSession.getToken(coordinate) == null;
    }

    public int getCoordinateDimension() {
        return Coordinate.DIMENSION;
    }

    public int getValueFromTurn() {
        return gameSession.getValueFromTurn();
    }

    public void continueState() {
        gameSession.next();
    }

    public boolean isTicTacToe() {
        return gameSession.isTicTacToe();
    }
}
