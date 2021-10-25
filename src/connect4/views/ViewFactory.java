package connect4.views;

import connect4.models.Board;
import connect4.models.Player;

public abstract class ViewFactory {

    public abstract BoardView createBoardView(Board board);

    public abstract CoordinateView createCoordinateView();
    
    public abstract PlayerView createPlayerView(Player player);
    
    public abstract ResumeView createResumeView();
    
    public abstract StartView createStartView();
    
    public abstract ErrorView createErrorView();
}
