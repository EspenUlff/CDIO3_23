package Model.Fields;

import Model.Player;

public class PropertyField extends Field{
    int price;
    Player owner;
    int rent;

    public PropertyField(String name, String subtext, int price, int rent) {
        super(name, subtext);
        this.price = price;
        this.owner = null;
        this.rent = rent;
    }

    @Override
    public void fieldEffect(Player player) {
        if (owner != null){
            player.addMoney(-rent);
            owner.addMoney(rent);

        }
    }
}