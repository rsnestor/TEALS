/**
 * ThreeOfAKind class determines the number of matching triplets among a given set of dice, 
 * when rolled a specified number of times (default is 5000).
 */
package edu.loudoun.jchs.exercises.chap4;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Roll three different die (of different faces), tracking 3 of a kind Key
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class ThreeOfAKind extends CommandLineRunner {

	protected Die[] dice = null;

	/**
	 * Roll three die, four, five, and six sided respectively, a given number of
	 * times (default 5000). Display how many triplets occurred.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Instantiate the dice and store as an array
		Die[] myDice = { new Die(4), new Die(5), new Die(6) };
		// Check if number of rolls has been passed in, otherwise default to 5k
		int rolls = (args.length > 0 ? Integer.parseInt(args[0]) : 5000);
		printf("Rolling three die %d times ... ", rolls);
		// Constuct ThreeOfAKind object with the dice array and roll for
		// triplets, displaying the result
		int triplets = new ThreeOfAKind(myDice).getTriplets(rolls);
		printf("triples encountered = %d (%s)\n",triplets,new DecimalFormat("##0.###%").format(triplets/(rolls*1.0)));
	}

	/**
	 * Constructor requires a Die array
	 * 
	 * @param dice
	 */
	public ThreeOfAKind(Die[] dice) {
		// Add the Die array to the internal ArrayList
		this.dice = dice;
	}

	/**
	 * Roll the internal dice <i>numRolls</i> times and count the number of
	 * triples.
	 * 
	 * @param numRolls
	 *            number of rolls of the dice set
	 * @return number of triples
	 */
	public int getTriplets(int numRolls) {
		int lastFace = -1;
		int triples = 0;
		// loop (roll) for the number of times requested
		for (int i = 0; i < numRolls; i++) {
			int rolls = 0;
			// loop through the Die array and roll each one
			for (Die die : dice) {
				int face = die.roll();
				if (lastFace > 0 && face != lastFace) {
					// No need to roll additional die if a mismatch is
					// encountered
					break;
				}
				lastFace = face;
				rolls++;
			}
			triples += (rolls == dice.length) ? 1 : 0;
		}
		return triples;
	}

}
