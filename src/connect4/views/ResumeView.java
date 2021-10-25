package connect4.views;

import static connect4.views.MessageView.*;

import connect4.controllers.ResumeController;
import utils.views.YesNoDialog;

class ResumeView {

    void interact(ResumeController resumeController) {
        
        resumeController.resume(new YesNoDialog().read(RESUME.getMessage()));
    }

}