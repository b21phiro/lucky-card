package src.cards;
public class Club extends Card {

    public Club(Integer value) {
        super(value);
        this.suit = "Clubs";
    }

    @Override
    public Integer getValue() {
        return this.number + 6;
    }

}
