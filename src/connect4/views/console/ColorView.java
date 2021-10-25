package connect4.views.console;

import connect4.types.Color;
import utils.views.Console;

class ColorView {

    void write(Color color) {
        
        String string = color.isNull() ? " " : color.name();
        Console.getInstance().write(string);
    }
    
}
