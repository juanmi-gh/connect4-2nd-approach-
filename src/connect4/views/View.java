package connect4.views;

import connect4.controllers.AcceptorController;
import connect4.controllers.ControllersVisitor;
import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;

public class View implements ControllersVisitor {

    private final StartView startView;
    private final PlayView playView;
    private final ResumeView resumeView;

    public View() {
        startView = new StartView();
        playView = new PlayView();
        resumeView = new ResumeView();
    }

    public void interact(AcceptorController acceptorController) {
        acceptorController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }

    @Override    
    public void visit(PlayController playController) {
        playView.interact(playController);
    }

    @Override    
    public void visit(ResumeController resumeController) {
        resumeView.interact(resumeController);
    }
}
