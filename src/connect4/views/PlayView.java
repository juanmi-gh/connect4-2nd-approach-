package connect4.views;

import connect4.controllers.PlayController;

class PlayView {

    void interact(PlayController playController) {
        new PlayMenu(playController).execute(); 
    }
}
