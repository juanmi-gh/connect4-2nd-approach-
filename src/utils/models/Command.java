package utils.models;

import utils.views.WithConsoleView;

public abstract class Command extends WithConsoleView {

    protected String title;
    
    protected Command(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }
    
    protected abstract void execute();

    protected abstract boolean isActive();

}