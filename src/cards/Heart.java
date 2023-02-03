package src.cards;
public class Heart extends Card {
    public Heart(Integer value) {
        super(value);
        this.suit = "Hearts";
    }

    // Returns the sum of the number-value + the value of the suit.
    @Override
    public Integer getValue() {
        return this.number + 8;
    }
}
