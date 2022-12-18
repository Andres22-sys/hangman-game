package org.andresdominguez.dev;

import org.andresdominguez.dev.user.Player;
import org.andresdominguez.dev.word.Word;

import java.util.Random;

public class Game {
    protected static final int MAX_INCORRECT_GUESSES = 6;
    private static final String[] WORDS = {"apple", "banana", "orange", "strawberry",
            "pineapple", "watermelon", "grape", "kiwi", "pear", "peach", "cherry",
            "blueberry", "raspberry", "blackberry", "lemon", "lime", "coconut", "mango",
            "apricot", "avocado", "tomato", "potato", "carrot", "pepper", "onion", "garlic",
            "celery", "cucumber", "spinach", "broccoli", "cauliflower", "asparagus", "lettuce",
            "cabbage", "mushroom", "corn", "zucchini", "squash", "eggplant", "pumpkin", "peas",
            "beans", "olive", "peanut", "almond", "cashew", "walnut", "hazelnut", "pecan", "macadamia",
            "pistachio", "sunflower", "chickpea", "lentil", "quinoa", "oat", "barley", "rice", "flour",
            "sugar", "salt", "butter", "milk", "cheese", "yogurt", "egg", "honey", "jam", "bread", "pasta",
            "pizza", "burger", "hotdog", "taco", "burrito", "sandwich", "cake", "cookie", "ice cream",
            "chocolate", "candy", "popcorn", "pretzel", "cracker", "chips", "soda", "juice", "coffee",
            "tea", "beer", "wine", "whiskey", "vodka", "rum", "gin", "brandy", "liqueur", "sake", "soy sauce",
            "ketchup", "mustard", "mayonnaise", "vinegar", "oil", "vinegar", "salsa", "guacamole", "salad",
            "soup", "stew", "chili", "curry", "tuna", "salmon", "trout", "cod", "halibut", "lobster", "crab",
            "shrimp", "clam", "oyster", "squid", "octopus", "eel", "frog", "toad", "snake", "lizard", "turtle"};

    private Word word;
    private Player player;
    private int incorrectGuesses;
    private boolean gameOver;

    public Game() {
        // Generate a random word for the player to guess
        Random rand = new Random();
        String randomWord = WORDS[rand.nextInt(WORDS.length)];
        word = new Word(randomWord);

        // Create a new player
        player = new Player();

        // Initialize the game state
        incorrectGuesses = 0;
        gameOver = false;
    }

    public void play() {
        while (!gameOver) {
            // Display the current game state
            displayGameState();

            // Get the player's next guess
            char guess = player.getNextGuess();

            // Check if the guess is correct
            if (word.containsLetter(guess)) {
                // If the guess is correct, reveal the letter in the word
                word.revealLetter(guess);
            } else {
                // If the guess is incorrect, increment the number of incorrect guesses
                incorrectGuesses++;
            }

            // Check if the player has won or lost
            if (word.isRevealed()) {
                // If the word is fully revealed, the player has won
                System.out.println("Congratulations, you won!");
                gameOver = true;
            } else if (incorrectGuesses >= MAX_INCORRECT_GUESSES) {
                // If the player has made too many incorrect guesses, they lose
                System.out.println("Sorry, you lost. The word was " + word.getWord() + ".");
                gameOver = true;
            }
        }
    }

    private void displayGameState() {
        // Display the number of incorrect guesses remaining
        System.out.println("Incorrect guesses remaining: " + (MAX_INCORRECT_GUESSES - incorrectGuesses));

        // Display the revealed letters of the word
        System.out.println("Word: " + word.getRevealedWord());
    }
}
