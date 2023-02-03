package src.decks;

import src.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private static Integer
        minCardValue,
        maxCardValue;

    // All the cards in the deck.
    private static ArrayList<Card> cards;

    public Deck(Integer minCardValue, Integer maxCardValue) {
        Deck.minCardValue = minCardValue;
        Deck.maxCardValue = maxCardValue;
    }

    /**
     * Returns the cards shuffled.
     * */
    public static ArrayList<Card> getShuffledCards() {
        ArrayList<Card> shuffledCards = new ArrayList<>(Deck.cards);
        Collections.shuffle(shuffledCards);
        return shuffledCards;
    }

    public static void setCards(ArrayList<Card> cards) {
        Deck.cards = cards;
    }

    public static Integer getMinCardValue() {
        return minCardValue;
    }

    public static Integer getMaxCardValue() {
        return maxCardValue;
    }

}
