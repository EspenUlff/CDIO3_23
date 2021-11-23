package Model.Fields;

public class FieldFactory {
    public static Field[] MakeFields() {

        return new Field[]{
                new StartField("Start", "Modtag 2 bobs"),
                new PropertyField("Burgerbaren", "1 bobs", 1, 1),
                new PropertyField("Pizzariaet", "1 bobs", 1, 1),
                new ChanceField("Chance", "WIP"),
                new PropertyField("Slikbutikken", "1 bobs", 1, 1),
                new PropertyField("Isboden", "1 bobs", 1, 1),
                new JailField("I fængsel", "På besøg (WIP)"),
                new PropertyField("Museet", "2 bobs", 2, 2),
                new PropertyField("Biblioteket", "2 bobs", 2, 2),
                new ChanceField("Chance", "WIP"),
                new PropertyField("Skaterpark", "2 bobs", 2, 2),
                new PropertyField("Swimmingpoolen", "2 bobs", 2, 2),
                new LooseChangeField("Gevinsten", "WIP"),
                new PropertyField("Spillehallen", "3 bobs", 3, 3),
                new PropertyField("Biografen", "3 bobs", 3, 3),
                new ChanceField("Chance", "WIP"),
                new PropertyField("Legetøjsbutikken", "3 bobs", 3, 3),
                new PropertyField("Dyrehandlen", "3 bobs", 3, 3),
                new GoToJailField("Gå i Fængsel", "WIP"),
                new PropertyField("Bowlinghallen", "4 bobs", 4, 4),
                new PropertyField("Zoologiskhave", "4 bobs", 4, 4),
                new ChanceField("Chance", "WIP"),
                new PropertyField("Vandlandet", "4 bobs", 4, 4),
                new PropertyField("Strandpromenaden", "4 bobs", 4, 4),
        };
    }
}
