package src;

import src.decks.Deck;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
* The "Game" class takes care of the business logic of everything while running the game-loop.
* */
public class Game {
    // The logger to use.
    private static Logger logger;

    // Instance of the game, can only be made once (singleton).
    private static Game instance;

    // The author of this application and the title of the game.
    protected static String
            author,
            title;

    // Current status of game (is it running?).
    protected static Boolean status;

    // The current score.
    protected static Integer score;

    // The card-deck that is being used.
    protected static Deck deck;

    // The constructor is private because of singleton-pattern of this class.
    private Game() {
        // Sets the logger for this class.
        Game.logger = Logger.getLogger(Game.class.getName());

        // Game author
        Game.author = "Philip Rosenqvist";

        Game.title = "Philip's Lucky Game";
    }

    // Stops the game loop.
    private static void stop() {
        Game.status = false;
    }

    // Sets the card deck that the game should use.
    public static void setDeck(Deck deck) {
        Game.deck = deck;
    }

    // Prints out a welcome message for the user.
    public static void welcomeMessage() {
        String message = String.format("Welcome to %s made by %s", Game.title, Game.author);
        System.out.println(message);
    }

    // Prints out a goodbye message for the user.
    public static void goodbyeMessage() {
        String message = String.format("Goodbye, see you later in %s!", Game.title);
        System.out.println(message);
    }

    /*
    * Sets the initial game-values for the game i.e. score and status.
    * Also checks if it has a deck to use etc.
    * NOTE: Exception will happen if no deck is set!
    * */
    public static void init() {
        try {

            // If the game is missing a card deck, an error will be thrown.
            if (Game.deck == null) throw new Exception("The game is missing a deck to use!");

            // Sets the initial values for the game.
            Game.status = false;
            Game.score = 0;

        } catch (Exception exception) {
            Game.logger.log(Level.SEVERE, "Error occurred while initiating the game:\n\t", exception);
        }
    }

    // Runs the game. NOTE: use AFTER init().
    public static void run() {
        try {
            // Game status is on "running" status now.
            Game.status = true;

            // Welcome message.
            Game.welcomeMessage();

            // The game loop.
            while(Game.status) {
                Game.stop();
            }

            // The game have stopped, a goodbye message is sent.
            Game.goodbyeMessage();

        } catch (Exception exception) {
            Game.logger.log(Level.SEVERE, "Error occurred while playing the game, reason:\n\t", exception);
        }
    }

    // Gets the instance of the game class. If there is none, the game class will be instanced once.
    public static Game getInstance() {
        if (Game.instance == null) Game.instance = new Game();
        return Game.instance;
    }

}
