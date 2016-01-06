package edu.loudoun.jchs.exercises.chap2;

import edu.loudoun.jchs.CommandLineRunner;

public class EscapeSequences extends CommandLineRunner {

	/**
	 * Solution key concepts: 
	 * 1) Use the backslash (\) to escape quote characters within a String 
	 * 2) Use two backslash characters to print a single backslash within a String
	 * 
	 * Coding note: This implementation uses "+=" assignment operator to append 
	 * Strings.  This operator can also be used for numeric data types calculate
	 * a running total.	 
	 * 
	 * @param days
	 */
	public static void main(String[] args) {
		String output = "This is simply a demonstration of \"quote marks\".\n";
		output += "\tIt also demonstrates the use of a tab character.\n";
		output += "\tRemember that the \"\\\" has a special meaning in java.\n";
		output += "This concludes this demonstration.\n";
		print(output);
	}

}
