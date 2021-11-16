package Model.Fields;

import Model.Player;

public abstract class Field {
    private final String name;
    private final String subtext;

    public Field(String name, String subtext) {
        this.name = name;
        this.subtext = subtext;
    }

    public abstract void fieldEffect(Player player);


    //Der er kun getters da der ikke er behov for at ændre dem efter de er lavet.
    public String getName() {
        return name;
    }

    public String getSubtext() {
        return subtext;
    }
}
