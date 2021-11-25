package Model.Fields;

import Model.Player;

import java.awt.Color;

public class PropertyField extends Field {
    public final int price;
    public final int rent;
    public final Color color;

    public Player owner;

    public PropertyField(String name, String subtext, int price, int rent, Color color) {
        super(name, subtext);
        this.price = price;
        this.color = color;
        this.owner = null;
        this.rent = rent;
    }

    @Override
    public void fieldEffect(Player player) {
        if (owner != null) {
            player.addMoney(-rent);
            owner.addMoney(rent);
        }
    }
}
