package src.cards;
public class Diamond extends Card {

    public Diamond(Integer value) {
        super(value);
    }

    @Override
    Integer getValue() {
        return this.value + 4;
    }

    @Override
    String getSuit() {
        return "Diamonds";
    }
}
