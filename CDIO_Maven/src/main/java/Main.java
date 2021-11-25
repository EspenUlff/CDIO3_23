import Model.Fields.FieldFactory;
import Model.Game.Game;
import View.GameView;

public class Main {
    public static void main(String[] args) {
        GameView view = new GameView(FieldFactory.MakeFields());
        Game game = new Game(view);
        game.run();
    }
}
