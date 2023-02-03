package src.cards;
public class Spade extends Card {
    public Spade(Integer value) {
        super(value);
        this.suit = "Spades";
    }

    @Override
    public Integer getValue() {
        return this.number + 10;
    }
}
