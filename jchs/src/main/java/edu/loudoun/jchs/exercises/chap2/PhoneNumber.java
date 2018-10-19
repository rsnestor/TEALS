package edu.loudoun.jchs.exercises.chap2;

import java.text.DecimalFormat;
import java.util.Random;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Solution key concepts: 
 * 1) Random class 
 * 2) DecimalFormat class
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class PhoneNumber extends CommandLineRunner {

	// create a java.util.Random instance
	Random rand = new Random();

	public static void main(String[] args) {
		// generate 20 numbers
		PhoneNumber numGenerator = new PhoneNumber();
		for (int i = 0; i < 20; i++) {
			println(numGenerator.generateRandomNumber(true));
		}
	}

	public long generateRandomNumber() {
		return Long.parseLong(generateRandomNumber(false));
	}

	/**
	 * Construct a random phone number that complies with the U.S. residential
	 * standard
	 * 
	 * @return
	 */
	public String generateRandomNumber(boolean formatted) {
		String phone = "";

		// Format the suffix to ensure leading zeros are not dropped
		DecimalFormat fmt = new DecimalFormat("0000");
		if (formatted) {
			// U.S. residential format
			phone = String.format("(%s) %s-%s", getAreaCode(), getPrefix(), fmt.format(rand.nextInt(10000)));
		} else {
			// number only
			phone = String.format("%s%s%s", getAreaCode(), getPrefix(), fmt.format(rand.nextInt(10000)));
		}

		return phone;
	}

	/**
	 * Generate a random area code. Rule: 1st digit > 1, all digits < 8
	 * 
	 * @return
	 */
	public String getAreaCode() {

		//Random.nextInt(max-min)+min
		String areaCode = Integer.toString(rand.nextInt(6)+2);
		// concatenate remaining area code digits (0-7)
		areaCode += rand.nextInt(8);
		areaCode += rand.nextInt(8);
		
		return areaCode;
	}

	/**
	 * Generate a random phone prefix. Rule: 200 < prefix < 743
	 * 
	 * @return prefix
	 */
	public String getPrefix() {
		//prefix cannot start with 0 or 1, and <= 742
		return Integer.toString(rand.nextInt(543)+200);
	}

}
