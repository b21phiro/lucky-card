package src.cards;
public class Diamond extends Card {

    public Diamond(Integer value) {
        super(value);
        this.suit = "Diamonds";
    }

    @Override
    public Integer getValue() {
        return this.number + 4;
    }
}
