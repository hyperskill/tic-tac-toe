package ticTacToe;

public class PlayerFactory {

    private PlayerFactory() {}

    public static Player getInstance(Enum player, char figure) {
        if (Players.EASY == player) {
            return new PlayerEasy(figure);
        }
        if (Players.MEDIUM == player) {
            return new PlayerMedium(figure);
        }
        if (Players.HARD == player) {
            return new PlayerHard(figure);
        }
        return new PlayerHuman(figure);
    }
}
