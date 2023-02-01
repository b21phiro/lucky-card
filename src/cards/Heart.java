package src.cards;
public class Heart extends Card {

    public Heart(Integer value) {
        super(value);
    }

    @Override
    Integer getValue() {
        return this.value + 8;
    }

    @Override
    String getSuit() {
        return "Hearts";
    }
}
