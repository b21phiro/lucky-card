package src.cards;
public abstract class Card {
    // Value of the card.
    protected Integer value;
    // Sets the value of the card.
    public Card(Integer value) {
        this.value = value;
    }
    // Gets the value of the card.
    abstract Integer getValue();
    // Gets the suit of the card.
    abstract String getSuit();
}

