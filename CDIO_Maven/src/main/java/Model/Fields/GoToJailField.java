package Model.Fields;

import Model.Game.Config;
import Model.Player;

public class GoToJailField extends Field{
    public GoToJailField(String name, String subtext) {
        super(name, subtext);
    }

    @Override
    public void fieldEffect(Player player) {
        //en setter til den givne spillers position
        player.setPosition(Config.JAIL_FIELD);
        player.setInJail(true);
    }
}
