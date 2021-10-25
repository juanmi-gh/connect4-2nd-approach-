package connect4.controllers.implementation;

import connect4.controllers.Logic;
import connect4.models.GameSession;
import connect4.types.StateValue;

public class GameLogic extends Logic {

    protected StartController startControllerImplementation;
    protected PlayController playControllerImplementation;
    protected ResumeController resumeControllerImplementation;

    public GameLogic() {
        session = new GameSession();
        startControllerImplementation = new StartController(session);
        playControllerImplementation = new PlayController(session);
        resumeControllerImplementation = new ResumeController(session);

        acceptorControllers.put(StateValue.INITIAL, startControllerImplementation);
        acceptorControllers.put(StateValue.IN_GAME, playControllerImplementation);
        acceptorControllers.put(StateValue.RESUME, resumeControllerImplementation);
        acceptorControllers.put(StateValue.EXIT, null);
    }

}
