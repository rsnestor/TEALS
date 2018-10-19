package edu.loudoun.jchs.reference;

/**
 * Variable assignment examples
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class Assignment {
	public static void main(String args[]) {
		int number = 75, bigNum = 99;
		double hTownTax = 8.25;
		char bigA = 'A', littleA = 'a';
		boolean isPrime = false;
		String s = "abc";

		System.out.println(number);
		System.out.println(bigNum);
		System.out.printf("%.2f", hTownTax);
		System.out.println(bigA);
		System.out.println(littleA);
		System.out.println(isPrime);
		System.out.println(s);

		// Suggestions
		System.out.println(
				String.format("Double.MIN_VALUE = %s, Double.MAX_VALUE = %s", Double.MIN_VALUE, Double.MAX_VALUE));
		System.out
				.println(String.format("Float.MIN_VALUE = %s, Float.MAX_VALUE = %s", Float.MIN_VALUE, Float.MAX_VALUE));
		System.out.println(
				String.format("Integer.MIN_VALUE = %s, Integer.MAX_VALUE = %s", Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(String.format("Long.MIN_VALUE = %s, Long.MAX_VALUE = %s", Long.MIN_VALUE, Long.MAX_VALUE));
	}
}