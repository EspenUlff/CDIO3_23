package View;

import Model.Fields.*;
import Model.Player;
import gui_fields.*;
import gui_main.GUI;

import java.awt.Color;

public class GameView {
    public final GUI ui;
    GUI_Field[] fields;
    GUI_Player[] players;

    public GameView(Field[] gameFields) {
        this.fields = new GUI_Field[gameFields.length];

        for (int i = 0; i < gameFields.length; i++) {
            this.fields[i] = translateGameField(gameFields[i]);
        }

        this.ui = new GUI(this.fields, new Color(160, 160, 160));
    }

    public GUI_Player findGuiPlayer(Player player) {
        GUI_Player guiPlayer = null;

        for (GUI_Player p : players) {
            if (p.getName().equals(player.name)) {
                guiPlayer = p;
                break;
            }
        }

        return guiPlayer;
    }

    public GUI_Field findGuiField(Field field) {
        GUI_Field guiField = null;

        for (GUI_Field f : fields) {
            if (f.getTitle().equals(field.name)) {
                guiField = f;
                break;
            }
        }

        return guiField;
    }

    public void updatePlayer(Player player) {
        GUI_Player guiPlayer = findGuiPlayer(player);

        guiPlayer.setBalance(player.getMoney());
        fields[player.prevPosition].setCar(guiPlayer, false);
        fields[player.position].setCar(guiPlayer, true);
    }

    public void setPlayers(Player... gamePlayers) {
        Color[] carColors = {
                new Color(101, 101, 210),
                new Color(194, 79, 79),
                new Color(222, 116, 48),
                new Color(10, 89, 10)
        };
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

    public void buyField(Player player) {
        GUI_Player guiPlayer = findGuiPlayer(player);

        GUI_Ownable ownedField = ((GUI_Ownable) fields[player.position]);
        ownedField.setOwnerName(player.name);
        ownedField.setBorder(guiPlayer.getPrimaryColor());
    }

    public void updateField(PropertyField field) {
        GUI_Field guiField = findGuiField(field);

        if (guiField instanceof GUI_Ownable guiOwnable) {
            guiOwnable.setRent(field.rent + "M");
        }
    }

    private GUI_Chance translateGameField(ChanceField field) {
        return new GUI_Chance(field.name, field.subtext, "", Color.BLACK, Color.WHITE);
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
        return new GUI_Street(field.name, field.subtext, "", field.rent + "M", field.color, Color.BLACK);
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
