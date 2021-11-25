package Model.ChanceCards;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardFactory {
    public static ChanceCard[] makeCards() {
        return new ChanceCard[]{};
    }

    public static LinkedList<ChanceCard> makeShuffledCards() {
        List<ChanceCard> cards = Arrays.asList(CardFactory.makeCards());
        Collections.shuffle(cards);
        return new LinkedList<>(cards);
    }
}
