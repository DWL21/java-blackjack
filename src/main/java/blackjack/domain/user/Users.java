package blackjack.domain.user;

import blackjack.domain.card.Cards;
import blackjack.domain.card.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Users {
    private final Dealer dealer;
    private final Players players;

    public Users(Dealer dealer, Players players) {
        this.dealer = dealer;
        this.players = players;
    }

    public void distributeToPlayers(Deck deck) {
        this.players.getPlayers()
                .forEach(player -> player.distribute(deck.popTwo()));
    }

    public List<Cards> showCardsByPlayers() {
        List<Cards> cards = new ArrayList<>();
        this.players.getPlayers()
                .forEach(player -> cards.add(new Cards(player.getCards())));
        return cards;
    }

    public List<String> getPlayerNames() {
        return Collections.unmodifiableList(this.players.getPlayers()
                .stream()
                .map(Player::getName)
                .collect(toList()));
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players.getPlayers());
    }
}
