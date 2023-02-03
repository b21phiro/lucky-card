package src.cards;
public class Club extends Card {

    public Club(Integer value) {
        super(value);
        this.suit = "Clubs";
    }

    // Returns the sum of the number-value + the value of the suit.
    @Override
    public Integer getValue() {
        return this.number + 6;
    }

}
