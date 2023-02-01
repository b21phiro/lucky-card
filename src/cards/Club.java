package src.cards;
public class Club extends Card {

    public Club(Integer value) {
        super(value);
    }

    @Override
    Integer getValue() {
        return this.value + 6;
    }

    @Override
    String getSuit() {
        return "Clubs";
    }
}
