package connect4.models;

public class Turn {

    public static final int NUM_PLAYERS = 2;

    private int value;

    private Player[] players;

    public Turn(Player[] players) {
        value = 0;
        this.players = players;
    }

    public Turn(Player[] players, int value) {
        this.value = value;
        this.players = players;
    }

    void change() {
        value = getOtherValue();
    }

    Player getPlayer() {
        return players[value];
    }

    int getValue() {
        return value;
    }

    private int getOtherValue() {
        return (value++) % NUM_PLAYERS;
    }

    Player getOtherPlayer() {
        return players[getOtherValue()];
    }

    Turn copy(Player[] players) {
        return new Turn(players, value);
    }

}