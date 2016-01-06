/**
 * ThreeOfAKind class determines the number of matching triplets among a given set of dice, 
 * when rolled a specified number of times (default is 5000).
 */
package edu.loudoun.jchs.exercises.chap4;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Requirements:
 * 1) Write an application that creates two individual Die objects.  Both Die objects will be 6-sided.  
 * 2) Roll the two individual Die objects 100,000 times, counting the number of times a 7, 11, or double (both 
 * dice have the same face value) is rolled.
 * 3) Print the number of times each case was rolled (7, 11, or double)
 * 4) Print the percentage that a 7, 11, or double was rolled in 100,000 trials.  Use a DecimalFormat 
 * object to round the percentage to the nearest hundredth (“0.00”). Odds are usually between 38 – 40%.
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class SevenElevenDoubles extends CommandLineRunner {

	protected Die die1 = null;
	protected Die die2 = null;

	/**
	 * Roll two six-sided die and track the number of 7, 11, and double roles
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SevenElevenDoubles roller = new SevenElevenDoubles(new Die(6),new Die(6));
		
		// Check if number of rolls has been passed in, otherwise default to 100k
		int rolls = (args.length > 0 ? Integer.parseInt(args[0]) : 100000);
		print(roller.roll(rolls));
	}

	/**
	 * Constructor requires a Die array
	 * 
	 * @param dice
	 */
	public SevenElevenDoubles(Die die1, Die die2) {
		// Add the Die array to the internal ArrayList
		this.die1 = die1;
		this.die2 = die2;
	}

	/**
	 * Roll the internal dice <i>numRolls</i> times and track roll
	 * statistics.
	 * 
	 * @param numRolls
	 *            number of rolls of the dice set
	 * @return RollStats stats
	 */
	public RollStats roll (int numRolls) {
		RollStats stats = new RollStats();
		// loop (roll) for the number of times requested
		for (int i = 0; i < numRolls; i++) {
			die1.roll(); 
			die2.roll();
			if (die1.getFaceValue()==die2.getFaceValue()) {
				stats.setDoubles(stats.getDoubles()+1);
			} else {
				int sum = die1.getFaceValue()+die2.getFaceValue();
				switch (sum) {
				case (7):
					stats.setSeven(stats.getSeven()+1);
					break;
				case (11):
					stats.setEleven(stats.getEleven()+1);
					break;
				}
			}
			stats.incRolls();
		}
		return stats;
	}
	
	/**
	 * Inner class to track rolls.
	 * 
	 * @author scottnestor - TEALS, 2015
	 *
	 */
	public class RollStats {
		
		private int seven = 0;
		private int eleven = 0;
		private int doubles = 0;
		private int rolls = 0;
		
		public int getSeven() {
			return seven;
		}
		public void setSeven(int seven) {
			this.seven = seven;
		}
		public int getEleven() {
			return eleven;
		}
		public void setEleven(int eleven) {
			this.eleven = eleven;
		}
		public int getDoubles() {
			return doubles;
		}
		public void setDoubles(int doubles) {
			this.doubles = doubles;
		}
		public void incRolls() {
			this.rolls++;
		}
		public int getRolls() {
			return rolls;
		}
		
		public void reset() {
			this.seven = 0;
			this.eleven = 0;
			this.doubles = 0;
			this.rolls = 0;
		}
		
		public String toString() {
			DecimalFormat fmt = new DecimalFormat("##0.##%");
			String stats = "Roll Statisics:\n";
			stats += String.format("   Doubles = %d (%s)\n",this.doubles, fmt.format(this.doubles/(double)this.rolls));
			stats += String.format("   Sevens = %d (%s)\n", this.seven, fmt.format(this.seven/(double)this.rolls));
			stats += String.format("   Elevens = %d (%s)\n", this.eleven, fmt.format(this.eleven/(double)this.rolls));
			stats += String.format("   Ratio of 7, 11, or double = %s\n", 
						fmt.format((this.eleven+this.seven+this.doubles)/(double)this.rolls));
			return stats;
		}
	}
}
