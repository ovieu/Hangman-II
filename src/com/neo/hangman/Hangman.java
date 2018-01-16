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

    public void run() {
		/* You fill this in */
		println("Welcome To Hangman!");

		//  create lexicon object
        hangmanLexicon = new HangmanLexicon();

        //  the game loop
        while (!gameOver()) {

            //  get secret word from lexicon
            String secretWord = hangmanLexicon.getWord(rgen.nextInt(0,9));

            //  create guessWord
            String guessWord = createGuessWord(secretWord);

            //  display secretWord
            println(guessWord);

//            //  get charGuess from user
//            String guessChar = getCharGuess();
//
//            if (secretWord.contains(guessChar)) {
//                updateSecretWord();
//                displayGuessMsg();
//            } else {
//                decrementGuessCount();
//                displayGuessMsg();
//            }
//
//            if (guessWord.equals(secretWord)) {
//                displayWinMsg();
//                break;
//            }
//
//            if (guessCount < 1) {
//                displayLoseMsg();
//                break;
//            }
        }
	}

    /** creates a guessword made up of dashes
     *  input ---> "name"
     *  oupup ---> "----"
     * @param secretWord
     * @return --------
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

}
