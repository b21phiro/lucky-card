package src.decks;

import src.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    // All the cards in the deck.
    private static ArrayList<Card> cards;

    public Deck() {}

    // Adds cards to the deck.
    public static void addCards(Card ...cards) {
        Deck.cards.addAll(List.of(cards));
    }

}
