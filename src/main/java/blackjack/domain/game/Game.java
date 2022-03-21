package blackjack.domain.game;

import blackjack.domain.cards.Card;

import java.util.List;


public class Game {

    public static State start(Card first, Card second) {
        final List<Card> cards = List.of(first, second);

        int sum = cards.stream()
                .mapToInt(Card::point)
                .sum();

        boolean hasAce = cards.stream()
                .anyMatch(Card::isAce);

        if (sum == 11 && hasAce) {
            return new Blackjack();
        }
        return new Hit();
    }
}
