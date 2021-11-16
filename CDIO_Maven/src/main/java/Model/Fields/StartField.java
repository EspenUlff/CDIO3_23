package Model.Fields;

import Model.Player;

public class StartField extends Field {

    public StartField(String name, String subtext) {
        super(name, subtext);
    }

    @Override
    public void fieldEffect(Player player) {
        player.addMoney(2);
    }
}
