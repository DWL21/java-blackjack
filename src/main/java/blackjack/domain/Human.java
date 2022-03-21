package blackjack.domain;

import java.util.List;

public abstract class Human {

    protected final String name;
    protected final PlayingCards cards = new PlayingCards();

    protected Human(final String name) {
        this.name = name;
    }

    public void dealInit(final List<Card> initCards) {
        cards.add(initCards);
    }

    public void hit(final Card card) {
        cards.add(card);
    }

    public boolean isWinner(final Human human) {
        if (human.isSameTotalPoints(getTotal())) {
            return isBlackjack();
        }
        return human.isBust() || human.hasTotalLowerThan(getTotal());
    }

    private boolean isBust() {
        return cards.isOverBlackjack();
    }

    boolean isBlackjack() {
        return cards.isBlackjack();
    }

    boolean isSameTotalPoints(final int total) {
        return getTotal() == total;
    }

    boolean hasTotalLowerThan(final int total) {
        return getTotal() < total;
    }

    abstract boolean canDraw();

    public List<String> getCards() {
        return cards.getAllNames();
    }

    public int getTotal() {
        return cards.calculateTotal();
    }

    public String getName() {
        return name;
    }
}
