package connect4.models;

import java.util.ArrayList;

public class Registry {
    
    private ArrayList<Memento> mementoList;
    
    private Game game;
    
    private int firstPrevious;
    
    Registry(Game game) {
        this.game = game;
        mementoList = new ArrayList<>();
        firstPrevious = 0;
    }

    void registry() {
        for (int i = 0; i < firstPrevious; i++) {
            mementoList.remove(0);
        }
        firstPrevious = 0;
        mementoList.add(firstPrevious, game.createMemento());
    }

    void undo(Game game) {
        firstPrevious++;
        game.set(this.mementoList.get(this.firstPrevious));
    }

    void redo(Game game) {
        firstPrevious--;
        game.set(this.mementoList.get(this.firstPrevious));
    }

    boolean undoable() {
        return firstPrevious < mementoList.size() - 1;
    }

    boolean redoable() {
        return firstPrevious >= 1;
    }

    void reset() {
        mementoList = new ArrayList<>();
        firstPrevious = 0;
    }
    
}
