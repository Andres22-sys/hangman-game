package org.andresdominguez.dev.user;

import java.util.Scanner;

public class Player {
    private static final Scanner INPUT_SCANNER = new Scanner(System.in);

    private String guessedLetters;

    public Player() {
        guessedLetters = "";
    }

    public char getNextGuess() {
        // Prompt the player for their next guess
        System.out.print("Enter your next guess: ");

        // Get the player's input
        String input = INPUT_SCANNER.nextLine();

        // Check that the input is a single letter
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Invalid input. Please enter a single letter.");
            return getNextGuess();
        }

        // Convert the input to lowercase
        char guess = Character.toLowerCase(input.charAt(0));

        // Check if the letter has already been guessed
        if (guessedLetters.indexOf(guess) >= 0) {
            System.out.println("You have already guessed that letter. Please try again.");
            return getNextGuess();
        }

        // Add the letter to the list of guessed letters
        guessedLetters += guess;

        return guess;
    }
}
