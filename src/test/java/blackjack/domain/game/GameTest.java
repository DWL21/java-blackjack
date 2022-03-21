package blackjack.domain.game;

import blackjack.domain.cards.Card;
import blackjack.domain.cards.Denomination;
import blackjack.domain.cards.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void start() {

        final State hit = Game.start(Card.of(Denomination.ACE, Suit.DIAMONDS), Card.of(Denomination.FIVE, Suit.SPADES));

        assertThat(hit).isInstanceOf(Hit.class);
    }

    @Test
    void blackjack() {

        final State blackjack = Game.start(Card.of(Denomination.ACE, Suit.DIAMONDS), Card.of(Denomination.TEN, Suit.SPADES));

        assertThat(blackjack).isInstanceOf(Blackjack.class);
    }

    @Test
    void stay() {

        final State hit = Game.start(Card.of(Denomination.ACE, Suit.DIAMONDS), Card.of(Denomination.FIVE, Suit.SPADES));

        hit.draw(Card.of(Denomination.SEVEN, Suit.SPADES));

        assertThat(hit).isInstanceOf(Bust.class);
    }


}
