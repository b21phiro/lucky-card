package src.cards;
public class Heart extends Card {
    public Heart(Integer value) {
        super(value);
        this.suit = "Hearts";
    }

    @Override
    public Integer getValue() {
        return this.number + 8;
    }
}
