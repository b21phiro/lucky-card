import src.Game;
import src.decks.Deck;

public class Main {
    public static void main(String[] args) {

        // Instance of the deck.
        Deck deck = new Deck(1, 13);

        // Sets the deck for the game.
        Game.setDeck(deck);

        // Initiating the game.
        Game.init();

        // Runs the game.
        Game.run();

    }
}
