package src.cards;
public class Spade extends Card {

    public Spade(Integer value) {
        super(value);
    }

    @Override
    Integer getValue() {
        return this.value + 10;
    }

    @Override
    String getSuit() {
        return "Spades";
    }
}
