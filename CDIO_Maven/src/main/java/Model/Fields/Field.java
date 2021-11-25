package Model.Fields;

import Model.Player;

public abstract class Field {
    public final String name;
    public final String subtext;

    public Field(String name, String subtext) {
        this.name = name;
        this.subtext = subtext;
    }

    public void fieldEffect(Player player){}
}
