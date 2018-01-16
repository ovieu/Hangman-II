/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

package com.neo.hangman;

import acm.program.ConsoleProgram;

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

        }
	}

	/** game is over if guess count is zero */
    private boolean gameOver() {
        return (guessCount < 1);
    }

    /** private instance variables  */
	private HangmanLexicon hangmanLexicon;
	private int guessCount = 10;    //  the amount of guess the user has per game

}
