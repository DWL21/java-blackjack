package blackjack.domain.cards;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card {

    private static final Map<String, Card> cache = new HashMap<>(52);

    private final Denomination denomination;
    private final Suit suit;

    private Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public static Card of(final Denomination denomination, final Suit suit) {
        return cache.computeIfAbsent(denomination.name() + suit.name(), ignored -> new Card(denomination, suit));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Card card = (Card) o;

        return denomination == card.denomination && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }

    public int point() {
        return denomination.getDenomination();
    }

    public boolean isAce() {
        return denomination == Denomination.ACE;
    }
}
