package View;

import Model.Fields.*;
import Model.Player;
import gui_fields.*;
import gui_main.GUI;

import java.awt.Color;
import java.util.Objects;

public class GameView {
    public final GUI ui;
    GUI_Field[] fields;
    GUI_Player[] players;

    public GameView(Field[] gameFields) {
        this.fields = new GUI_Field[gameFields.length];

        for (int i = 0; i < gameFields.length; i++) {
            this.fields[i] = translateGameField(gameFields[i]);
        }

        this.ui = new GUI(this.fields);
    }

    public void updatePlayer(Player player) {
        GUI_Player guiPlayer = null;

        for (GUI_Player p : players) {
            if (p.getName().equals(player.name)) {
                guiPlayer = p;
                break;
            }
        }

        Objects.requireNonNull(guiPlayer).setBalance(player.getMoney());
        fields[player.prevPosition].setCar(guiPlayer, false);
        fields[player.position].setCar(guiPlayer, true);
    }

    public void setPlayers(Player... gamePlayers) {
        Color[] carColors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.BLACK, Color.MAGENTA};
        players = new GUI_Player[gamePlayers.length];

        for (int i = 0; i < players.length; i++) {
            GUI_Car tmpCar = new GUI_Car();
            tmpCar.setPrimaryColor(carColors[i]);

            players[i] = new GUI_Player(gamePlayers[i].name, gamePlayers[i].getMoney(), tmpCar);
            players[i].setBalance(gamePlayers[i].getMoney());
            ui.addPlayer(players[i]);
        }
    }

    public void resetBoard() {
        for (GUI_Player player : players) {
            fields[0].setCar(player, true);
        }
    }

    private GUI_Chance translateGameField(ChanceField field) {
        return new GUI_Chance(field.name, field.subtext, "", Color.WHITE, Color.BLACK);
    }

    private GUI_Jail translateGameField(GoToJailField field) {
        return new GUI_Jail("default", field.name, field.subtext, "", Color.WHITE, Color.BLACK);
    }

    private GUI_Jail translateGameField(JailField field) {
        return new GUI_Jail("default", field.name, field.subtext, "", Color.WHITE, Color.BLACK);
    }

    private GUI_Refuge translateGameField(LooseChangeField field) {
        return new GUI_Refuge("default", field.name, field.subtext, "", Color.WHITE, Color.BLACK);
    }

    private GUI_Street translateGameField(PropertyField field) {
        return new GUI_Street(field.name, field.subtext, "", field.rent + "M", Color.WHITE, Color.BLACK);
    }

    private GUI_Start translateGameField(StartField field) {
        return new GUI_Start(field.name, field.subtext, "", Color.RED, Color.BLACK);
    }

    private GUI_Field translateGameField(Field field) {
        if (field instanceof ChanceField)
            return translateGameField((ChanceField) field);
        if (field instanceof GoToJailField)
            return translateGameField((GoToJailField) field);
        if (field instanceof JailField)
            return translateGameField((JailField) field);
        if (field instanceof LooseChangeField)
            return translateGameField((LooseChangeField) field);
        if (field instanceof PropertyField)
            return translateGameField((PropertyField) field);
        if (field instanceof StartField)
            return translateGameField((StartField) field);
        return null;
    }
}
