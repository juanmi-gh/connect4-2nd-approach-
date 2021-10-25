package connect4.views.console;

import static connect4.views.Message.*;

import utils.views.YesNoDialog;

public class ResumeView implements connect4.views.ResumeView {

    public boolean read() {
 
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(RESUME.toString());
        
        return isResumed.isAffirmative();
    }

}
