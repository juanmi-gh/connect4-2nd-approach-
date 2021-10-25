package utils.models;

import utils.views.Console;
import utils.views.WithConsoleView;

public class PlayersDialog extends WithConsoleView {

    private static final String USERS_ERROR = "Wrong number of users";

    public int read(int players) {

        int users = 0;
        do {
            users = Console.getInstance().readInt("Number of users [0-" + players + "] ");
            
            if (invalidNumberOfUsers(users)) {
                Console.getInstance().writeln(USERS_ERROR);
            }
        } while(invalidNumberOfUsers(users));
        
        return users;
    }
    
    private boolean invalidNumberOfUsers(int users) {
        return users < 0 || users > 2;
    }
}
