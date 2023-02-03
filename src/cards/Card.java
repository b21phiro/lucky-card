package src.cards;
public abstract class Card {
    // The card suit.
    protected String suit;
    // The number of the card (i.e. base-value and position).
    protected Integer number;

    public Card(Integer number) {
        // The card number.
        this.number = number;
    }

    // Returns the value of the card.
    public abstract Integer getValue();

    // Gets the card as string.
    public String getCard() {
        return String.format("%s %d", this.suit, this.number);
    }
}

