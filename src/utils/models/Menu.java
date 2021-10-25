package utils.models;

import java.util.ArrayList;
import java.util.List;

import utils.views.Console;
import utils.views.WithConsoleView;

public abstract class Menu extends WithConsoleView {

    private static final String OPTION = "----- Choose one option -----";
    
    private ArrayList<Command> commandList;

    public Menu() {
        commandList = new ArrayList<>();
    }

    public void execute() {

        List<Command> commands = getActiveCommands();

        boolean error;
        int option;
        do {
            error = false;
            Console.getInstance().writeln();
            Console.getInstance().writeln(Menu.OPTION);

            for (int i = 0; i < commands.size(); i++) {
                Console.getInstance().writeln((i + 1) + ") " + commands.get(i).getTitle());
            }

            option = Console.getInstance().readInt("") - 1;
            if (!new ClosedInterval(0, commands.size()-1).isIncluded(option)) {
                error = true;
            }
        } while (error);
        
        commands.get(option).execute();
    }
    
    private List<Command> getActiveCommands() {
        
        List<Command> commands = new ArrayList<>();
        
        for (Command command : commandList) {
            if (command.isActive()) {
                commands.add(command);
            }
        }
        
        return commands;
    }

    protected void addCommand(Command command) {
        commandList.add(command);
    }

}