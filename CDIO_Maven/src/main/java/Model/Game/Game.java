package Model.Game;

import Model.ChanceCards.CardFactory;
import Model.ChanceCards.ChanceCard;
import Model.Fields.Field;
import Model.Fields.FieldFactory;
import Model.Fields.PropertyField;
import Model.Player;
import View.GameView;

import java.util.LinkedList;
import java.util.List;


public class Game {
    public LinkedList<ChanceCard> chanceCards = CardFactory.makeShuffledCards();
    public Field[] fields = FieldFactory.MakeFields();
    public boolean ended = false;
    public Player[] players;
    // public Player active;
    public GameView view;

    public Game(GameView view) {
        this.view = view;

        int playerAmount = this.view.ui.getUserInteger("Hvor mange spillere? (mellem 2-4)", Config.MIN_PLAYERS, Config.MAX_PLAYERS);
        String[] playerNames = new String[playerAmount];

        for (int i = 0; i < playerAmount; i++) {
            playerNames[i] = this.view.ui.getUserString("Hvad er navnet på spiller" + (i + 1) + "?");
        }

        Player[] players = new Player[playerNames.length];

        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }

        view.setPlayers(players);
        view.resetBoard();

        this.players = players;
        // this.active = players[0];
    }

    public void run() {
        while (!ended) {
            playRound();
        }
    }

    public void playRound() {
        for (Player player : players) {
            // active = player;
            playTurn(player);
            updateUI();
        }
    }

    /**
     * This method handles playing 1 turn for the given player
     *
     * @param player Player whose turn it is
     */
    private void playTurn(Player player) {
        String action;
        if (player.inJail) {
            if (player.outOfJailFree) {
                player.outOfJailFree = false;
            } else {
                player.addMoney(-1);
                view.updatePlayer(player);
            }
        }

        // Use this action if there is more than 1 choice for the player...
        // In this case there's only one choice, so it doesn't really matter
        action = view.ui.getUserButtonPressed(player.name + "'s tur. Vælg handling", Config.ACTIONS_START_TURN);

        int[] rolls = Dice.roll();
        int rollSum = rolls[0] + rolls[1];
        view.ui.setDice(rolls[0], rolls[1]);
        boolean extraTurn = rolls[0] == rolls[1];

        movePlayerForward(player, rollSum);
        fields[player.getPosition()].fieldEffect(player);

        view.updatePlayer(player);

        Field playerField = fields[player.getPosition()];
        if (playerField instanceof PropertyField field) {
            if (field.getOwner() == null) {
                action = view.ui.getUserButtonPressed(player.name + "'s turn. Pick an action", Config.ACTIONS_PROPERTY);

                // We only check for the first action since the other simply skips the purchase and goes on with the turn
                if (action.equals(Config.ACTIONS_PROPERTY[0])) {
                    if (player.getMoney() < field.price) {
                        view.ui.getUserButtonPressed("Du har ikke nok penge", "Ok");
                    } else {
                        player.addMoney(-field.price);
                        field.setOwner(player);
                        view.updatePlayer(player);
                        view.buyField(player);
                        doubleRentIfSameOwner(field);
                    }
                }
            } else view.updatePlayer(field.getOwner());
        }

        action = view.ui.getUserButtonPressed(player.name + "'s turn. Pick an action", Config.ACTIONS_END_TURN);
        if (extraTurn) playTurn(player);
    }

    /**
     * Moves a given player forward by the given amount.
     * It also makes sure to give the player money if they pass the start field
     *
     * @param player Player to move
     * @param amount Amount of spaces to move
     */
    private void movePlayerForward(Player player, int amount) {
        player.setPosition((player.getPosition() + amount) % fields.length);

        // Check if the player passed the start field and give money if they do
        if (player.getPosition() < player.getPrevPosition()) player.addMoney(Config.ROUND_MONEY);
    }

    private List<PropertyField> findSameColorFields(PropertyField field) {
        List<PropertyField> colorFields = new LinkedList<>();

        for (Field f : fields) {
            if (f instanceof PropertyField f1) {
                if (f1.color == field.color) {
                    colorFields.add(f1);
                }
            }
        }

        return colorFields;
    }

    private void doubleRentIfSameOwner(PropertyField field) {
        List<PropertyField> colors = findSameColorFields(field);
        Player owner = colors.get(0).getOwner();

        for (PropertyField f : colors) {
            if (f.getOwner() != owner) return;
        }

        for (PropertyField f : colors) {
            f.rent += f.rent;
            view.updateField(f);
        }
    }

    /**
     * Delete this is you don't need it, I'm not sure ¯\_(ツ)_/¯
     */
    private void updateUI() {
        for (Player player : players) {
            view.updatePlayer(player);
        }
    }
}
