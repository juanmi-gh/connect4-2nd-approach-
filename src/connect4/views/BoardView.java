package connect4.views;

import static connect4.types.Coordinate.*;

import java.util.ArrayList;
import java.util.List;

import connect4.types.Color;

public abstract class BoardView {

    protected List<Color> colors;

    public BoardView() {
        colors = new ArrayList<>();
    }

    public void set(Color color) {
        assert colors.size() < DIMENSION * DIMENSION;

        colors.add(color);
    }

    public abstract void write();

}
