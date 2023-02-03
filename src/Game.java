package src;

import src.cards.*;
import src.decks.Deck;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* The "Game" class takes care of the business logic of everything while running the game-loop.
* */
public class Game {
    // The logger to use.
    private static Logger logger;

    // The author of this application and the title of the game.
    protected static String
            author,
            title;

    // Current status of game (is it running?).
    protected static Boolean status;

    // The current score and round.
    protected static Integer
            score,
            currentRound;

    // The card-deck that is being used.
    protected static Deck deck;

    // The constructor is private because of singleton-pattern of this class.
    public Game() {
        // Sets the logger for this class.
        Game.logger = Logger.getLogger(Game.class.getName());

        // The games author.
        Game.author = "Philip Rosenqvist";

        // Title of the game.
        Game.title = "Philip's Lucky Game";
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
            Game.currentRound = 0;

            // The cards to add to deck later.
            ArrayList<Card> cards = new ArrayList<>();
            // Adds the card suits to the cards array.
            int cardTypeIterator = 0;
            while (cardTypeIterator < 4) {
                for (int cardValue = Deck.getMinCardValue(); cardValue <= Deck.getMaxCardValue(); cardValue++) {
                    switch (cardTypeIterator) {
                        case 0 ->
                            // Hearts
                                cards.add(new Heart(cardValue));
                        case 1 ->
                            // Clubs
                                cards.add(new Club(cardValue));
                        case 2 ->
                            // Diamonds
                                cards.add(new Diamond(cardValue));
                        case 3 ->
                            // Spades
                                cards.add(new Spade(cardValue));
                        default -> {
                        }
                    }
                }
                cardTypeIterator++;
            }

            // Sets the cards to deck.
            Deck.setCards(cards);

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

            // User input.
            Scanner input = new Scanner(System.in);

            // The game loop.
            while(Game.status) {

                // New round.
                Game.currentRound++;

                // Tells the player that the new round has begun.
                System.out.printf("#### RUNDA %d! ####%n", Game.currentRound);

                // Gets a shuffled deck of cards for this round.
                ArrayList<Card> cards = Deck.getShuffledCards();

                // ALl the values from the cards.
                int[] values;
                values = new int[3];

                for (int i = 0; i < 3; i++) {
                    // Draws top card in heap.
                    Card card = cards.get(i);

                    // Prints out the card.
                    System.out.println("Card "+(i+1)+": "+card.getCard()+" -> Value = "+card.getValue());

                    // Pushes the values inside the values[] array.
                    values[i] = card.getValue();
                }

                // If the third card-value is between the first and second value, then the player wins.
                if (values[2] > values[0] && values[2] < values[1] || values[2] > values[1] && values[2] < values[0]) {
                    // Player won.
                    Game.score++;
                    System.out.printf("You won round %d!%n", Game.currentRound);
                } else {
                    // Player lost.
                    System.out.printf("You lost the round %d.%n", Game.currentRound);
                }

                // Displays the current score.
                System.out.printf("\nCurrent Score: %d.", Game.score);

                // Asks if the user wants to continue. If user press q, the game quits.
                System.out.print("\nPress ENTER to play again, or \"q\" to quit the game: ");
                String line = input.nextLine();

                if (line.equals("q")) {
                    Game.status = false;
                }

            }

            // The game have stopped, a goodbye message is sent.
            Game.goodbyeMessage();

        } catch (Exception exception) {
            Game.logger.log(Level.SEVERE, "Error occurred while playing the game, reason:\n\t", exception);
        }
    }

}
