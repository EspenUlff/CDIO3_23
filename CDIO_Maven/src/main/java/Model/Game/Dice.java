package Model.Game;

public class Dice {
    public static int[] roll(int amount, int sides) {
        int[] results = new int[amount];
        for (int i = 0; i < amount; i++) {
            results[i] = (int) (Math.random() * sides + 1);
        }
        return results;
    }

    public static int[] roll() {
        return Dice.roll(Config.DIE_AMOUNT, Config.DIE_SIDES);
    }
}
