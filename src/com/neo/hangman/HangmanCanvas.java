/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */
package com.neo.hangman;

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		removeAll();
		displayScaffold();
	}

    private void displayScaffold() {

    }

    /**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
        guessWordLabel.setFont("Courier-24");
        guessWordLabel.setLabel(word);
		add(guessWordLabel, 0.4 * getWidth(), 0.7 * getHeight());
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String incorrectGuessStr) {
		/* You fill this in */
        wrongWordLabel.setFont("Courier-24");
        wrongWordLabel.setLabel(incorrectGuessStr);
        add(wrongWordLabel, 0.4 * getWidth(), 0.75 * getHeight());

        //  display body parts
        displayHangmanBody(incorrectGuessStr);
	}

    /** displays the body of the hangman depending on the
     *  number of incorect guesses"
     * @param incorrectGuessStr the incorrect guesses by the player
     */
    private void displayHangmanBody(String incorrectGuessStr) {
        int incorrectGuessLen = incorrectGuessStr.length();
        switch (incorrectGuessLen) {
            case 1: displayHead();
                break;
            case 2: displayBody();
                break;
            case 3: displayShoulder();
                break;
            case 4: displayRightArm();
                break;
            case 5: diplayLeftArm();
                break;
            case 6: displayHips();
                break;
            case 7: displayRightLeg();
                break;
            case 8: diplayLeftLeg();
                break;
            default: break;
        }
    }

    /* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	/** private instance variables representing items on screen */
	private GLabel guessWordLabel = new GLabel("");
	private GLabel wrongWordLabel = new GLabel("");
	private GOval head;
	private GLine body, shoulder, rightArm, leftArm, hips, rightLeg, leftLeg;
	private GLine scaffoldPole, scaffoldLedge, scaffoldRope;


}
