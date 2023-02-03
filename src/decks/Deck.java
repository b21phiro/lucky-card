package src.decks;

import src.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // The minimum amount of cards and maximum amount of cards.
    private final Integer minCardValue;
    private final Integer maxCardValue;

    // All the cards in the deck.
    private ArrayList<Card> cards;

    public Deck(Integer minCardValue, Integer maxCardValue) {
        this.minCardValue = minCardValue;
        this.maxCardValue = maxCardValue;
    }

    // Returns the cards shuffled.
    public ArrayList<Card> getShuffledCards() {
        ArrayList<Card> shuffledCards = new ArrayList<>(this.cards);
        Collections.shuffle(shuffledCards);
        return shuffledCards;
    }

    // Sets the cards to use into the deck.
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    // Gets the minimum amount of cards.
    public Integer getMinCardValue() {
        return this.minCardValue;
    }

    // Gets the maximum amount of cards.
    public Integer getMaxCardValue() {
        return this.maxCardValue;
    }

}
