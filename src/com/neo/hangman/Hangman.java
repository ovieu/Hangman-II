/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

package com.neo.hangman;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Hangman extends ConsoleProgram {

    public static void main(String[] args) {
        new Hangman().start(args);
    }

    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
    }
    public void run() {
		/* You fill this in */
		println("Welcome To Hangman!");

		//  create lexicon object
        hangmanLexicon = new HangmanLexicon();

        //  the game loop
        while (!gameOver()) {
            //  insert new line
            println();

            //  get secret word from lexicon
            String secretWord = hangmanLexicon.getWord(rgen.nextInt(0,9));

            //  create guessWord
            String guessWord = createGuessWord(secretWord);

            while (true) {
                //  diplay hint of new word
                println("The word now looks like this: " + guessWord);

                //  get single string from user
                String singleStringGuess = getSingleStringGuess();

                /*  check if secret word contains letter */
                if (secretWord.contains(singleStringGuess)) {
                    guessWord = updateGuessWord(secretWord, guessWord, singleStringGuess);
                    displayGuessMsg(guessWord, guessCount);
                    println();
                } else {
                    guessCount--;
                    println("There are no " + singleStringGuess + "'s in the word");
                    displayGuessMsg(guessWord, guessCount);
                    println();
                }

                if (guessWord.equals(secretWord)) {
                    displayWinMsg(guessWord);
                    break;
                }

                if (guessCount < 1) {
                    displayLoseMsg(secretWord);
                    break;
                }
            }

        }
	}

	/** display lose message */
    private void displayLoseMsg(String secretWord) {
        println("The word was: " + secretWord);
        println("You Lose.");
    }

    /** display the win message */
    private void displayWinMsg(String guessWord) {
        println("You guessed the word: " + guessWord);
        println("You Win");
    }

    /** displays the result of the guess    */
    private void displayGuessMsg(String guessWord, int guessCount) {
        println("You have " + guessCount + " guesses left");
    }

    /** update the guess word to reflect the guessed character  */
    private String updateGuessWord(String secretWord, String guessWord, String sStrGuess) {
        String result = "";
        for (int i = 0; i < secretWord.length(); i++ ) {
           if (guessWord.charAt(i) == '-') {
               if (secretWord.charAt(i) == sStrGuess.charAt(0)) {
                   result += sStrGuess.charAt(0);
               } else {
                   result += guessWord.charAt(i);
               }
           } else {
               result += guessWord.charAt(i);
           }
        } return result;
    }

    /** gets the users guess. returns a String with one char (uppercase)
     * @return a single character string in uppercase
     */
    private String getSingleStringGuess() {
        String input = "";
        while (true) {
            input = readLine("Enter a guess: ");
            if (isValidSingleString(input)) break;
        }
        return input.toUpperCase();
    }

    /** the character is valid if it is an alphabet and length == 1 */
    private boolean isValidSingleString(String input) {
        if (input.length() == 1) {
            if (!Character.isLetter(input.charAt(0))) {
                println("Not a valid alphabet, try again. ");
            } else {
                return Character.isLetter(input.charAt(0));
            }
        }
        println("Not a valid alphabet, try again. ");
        return false;
    }

    /** creates a guessword made up of dashes
     * @param secretWord the input from the user
     * @return result the same word but represented by dashes "----"
     */
    private String createGuessWord(String secretWord) {
        String result = "";
        for (int i = 0; i < secretWord.length(); i++) {
            result += "-";
        }
        return result;
    }

    /** game is over if guess count is zero */
    private boolean gameOver() {
        return (guessCount < 1);
    }

    /** private instance variables  */
	private HangmanLexicon hangmanLexicon;
	private int guessCount = 10;    //  the amount of guess the user has per game
    private static RandomGenerator rgen = RandomGenerator.getInstance();
    private HangmanCanvas canvas;
}
