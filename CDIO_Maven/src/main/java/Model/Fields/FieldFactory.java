package Model.Fields;

import java.awt.*;

public class FieldFactory {
    public static Field[] MakeFields() {

        return new Field[]{
                new StartField("Start", "Modtag 2 M"),
                new PropertyField("Burgerbaren", "1 M", 1, 1, new Color(102, 70, 23)),
                new PropertyField("Pizzariaet", "1 M", 1, 1, new Color(102, 70, 23)),
                new ChanceField("?", "Chance WIP"),
                new PropertyField("Slikbutikken", "1 M", 1, 1, Color.CYAN),
                new PropertyField("Isboden", "1 M", 1, 1, Color.CYAN),
                new JailField("I fængsel", "På besøg (WIP)"),
                new PropertyField("Museet", "2 M", 2, 2, Color.MAGENTA),
                new PropertyField("Biblioteket", "2 M", 2, 2, Color.MAGENTA),
                new ChanceField("?", "Chance WIP"),
                new PropertyField("Skaterpark", "2 M", 2, 2, Color.ORANGE),
                new PropertyField("Swimmingpoolen", "2 M", 2, 2, Color.ORANGE),
                new LooseChangeField("Gevinsten", "WIP"),
                new PropertyField("Spillehallen", "3 M", 3, 3, Color.RED),
                new PropertyField("Biografen", "3 M", 3, 3, Color.RED),
                new ChanceField("?", "Chance WIP"),
                new PropertyField("Legetøjsbutikken", "3 M", 3, 3, Color.YELLOW),
                new PropertyField("Dyrehandlen", "3 M", 3, 3, Color.YELLOW),
                new GoToJailField("Gå i Fængsel", "WIP"),
                new PropertyField("Bowlinghallen", "4 M", 4, 4, Color.GREEN),
                new PropertyField("Zoologiskhave", "4 M", 4, 4, Color.GREEN),
                new ChanceField("?", "Chance WIP"),
                new PropertyField("Vandlandet", "4 M", 4, 4, Color.BLUE),
                new PropertyField("Strandpromenaden", "4 M", 4, 4, Color.BLUE),
        };
    }
}
