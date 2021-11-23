package Model.ChanceCards;

public abstract class ChanceCard {
    private final String text;

    public ChanceCard(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
