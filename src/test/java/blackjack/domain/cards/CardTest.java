package blackjack.domain.cards;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    @Test
    void of() {
        final Card card = Card.of(Denomination.ACE, Suit.DIAMONDS);

        assertThat(card).isSameAs(Card.of(Denomination.ACE, Suit.DIAMONDS));
    }
}
