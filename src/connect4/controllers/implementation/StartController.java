package connect4.controllers.implementation;

import connect4.models.GameSession;
import connect4.models.Session;

public class StartController extends connect4.controllers.StartController {

    GameSession gameSession;

    public StartController(Session session) {
        super(session);
        gameSession = ((GameSession) session);
    }

    public void createPlayers(int numberOfUsers) {
        gameSession.createPlayers(numberOfUsers);
    }

    @Override
    public void start() {
        gameSession.next();      
    }

}
