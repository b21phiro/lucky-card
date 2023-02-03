import src.Game;
import src.decks.Deck;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        // Instance of the deck.
        Deck deck = new Deck(1, 13);

        // Sets the logger for the game to use.
        Game.setLogger(Logger.getLogger(Game.class.getName()));

        // Sets the deck for the game.
        Game.setDeck(deck);

        // Initiating the game.
        Game.init();

        // Runs the game.
        Game.run();

    }
}
