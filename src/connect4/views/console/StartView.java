package connect4.views.console;

import static connect4.views.Message.*;

public class StartView implements connect4.views.StartView {

    public void write() {
        new MessageView().writeln(TITLE);
    }

}