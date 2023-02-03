package src.cards;
public class Diamond extends Card {

    public Diamond(Integer value) {
        super(value);
        this.suit = "Diamonds";
    }

    // Returns the sum of the number-value + the value of the suit.
    @Override
    public Integer getValue() {
        return this.number + 4;
    }
}
