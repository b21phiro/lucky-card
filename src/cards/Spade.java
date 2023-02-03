package src.cards;
public class Spade extends Card {
    public Spade(Integer value) {
        super(value);
        this.suit = "Spades";
    }

    // Returns the sum of the number-value + the value of the suit.
    @Override
    public Integer getValue() {
        return this.number + 10;
    }
}
