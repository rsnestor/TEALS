/**
 * 
 */
package edu.loudoun.jchs.exercises.chap3;

import java.util.Random;

import edu.loudoun.jchs.CommandLineScanner;

/**
 * Number guessing game.
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class HiLow extends CommandLineScanner {

	private int aiNumber = -1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int guess = 0;
		String play = "y";
		println("I've got a number between 0-100.  You have five guesses.");
		while (play.equals("y")) {
			HiLow game = new HiLow();
			for (int g = 1; g < 6; g++) {
				printf("Guess (%d): ", g);
				guess = nextInt();
				if (game.guess(guess) == 0) {
					printf("You got it (%d) in %d guesses!\n", guess, g);
					break;
				} else if (game.guess(guess) < 0) {
					println("Too high");
				} else {
					println("Too low");
				}
			}
			printf("The number was %d\n", game.aiNumber);
			print("Play again (y/n)? ");
			play = next().toLowerCase();
		}
	}

	public HiLow() {
		super();
		//random number 0-100
		aiNumber = new Random().nextInt(101);
	}

	public int guess(int guess) {
		return (aiNumber<guess)?-1:((aiNumber>guess)?1:0);
	}

}
