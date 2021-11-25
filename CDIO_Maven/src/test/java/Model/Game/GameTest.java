package Model.Game;

import Model.Fields.FieldFactory;
import Model.Player;
import View.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    GameView view;
    Game game;
    Player[] players;

    @BeforeEach
    void setUp() {
        view = new GameView(FieldFactory.MakeFields());
        game = new Game(view);
        players = new Player[] {new Player("Test 1")};
    }

    @Test
    void playTurnTest() {
        game.playTurn(players[0]);
    }
}