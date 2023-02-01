import src.decks.Deck;

public class Main {
    public static void main(String[] args) {

        // Instance of the game.
        src.Game game = src.Game.getInstance();

        // Instance of the deck.
        Deck deck = new Deck();

        deck.addCards();

        // Sets the deck for the game.
        game.setDeck(deck);

        // Initiating the game.
        game.init();

        // Runs the game.
        game.run();

    }
}
