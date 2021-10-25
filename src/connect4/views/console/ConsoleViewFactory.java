package connect4.views.console;

import connect4.models.Board;
import connect4.models.Player;
import connect4.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

    @Override
    public BoardView createBoardView(Board board) {
        return new BoardView(board);
    }

    @Override
    public CoordinateView createCoordinateView() {
        return new CoordinateView();
    }

    @Override
    public PlayerView createPlayerView(Player player) {
        return new PlayerView(player);
    }

    @Override
    public ResumeView createResumeView() {
        return new ResumeView();
    }

    @Override
    public StartView createStartView() {
        return new StartView();
    }

    @Override
    public ErrorView createErrorView() {
        return new ErrorView();
    }

}
