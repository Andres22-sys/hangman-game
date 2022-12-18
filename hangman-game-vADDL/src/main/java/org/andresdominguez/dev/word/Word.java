package org.andresdominguez.dev.word;

public class Word {
    private String word;
    private boolean[] revealedLetters;

    public Word(String word) {
        this.word = word;

        // Initialize the revealed letters array with all letters hidden
        revealedLetters = new boolean[word.length()];
    }

    public boolean containsLetter(char letter) {
        // Check if the word contains the given letter
        return word.indexOf(letter) >= 0;
    }

    public void revealLetter(char letter) {
        // Reveal all occurrences of the given letter in the word
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                revealedLetters[i] = true;
            }
        }
    }

    public boolean isRevealed() {
        // Check if all letters in the word have been revealed
        for (boolean letterRevealed : revealedLetters) {
            if (!letterRevealed) {
                return false;
            }
        }
        return true;
    }

    public String getWord() {
        return word;
    }

    public String getRevealedWord() {
        // Construct a string of the revealed letters in the word
        String revealedWord = "";
        for (int i = 0; i < word.length(); i++) {
            if (revealedLetters[i]) {
                revealedWord += word.charAt(i);
            } else {
                revealedWord += "*";
            }
        }
        return revealedWord;
    }
}
