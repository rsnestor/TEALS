package edu.loudoun.jchs.reference;

/**
 * Initial exploration of String
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class Strings {
	public static void main(String args[]) {
		String hello = "hello world";
		String sixBackslash = "whoot - \\\\\\\\\\\\";

		System.out.println(hello);
		System.out.println(sixBackslash);

		// string formatting
		System.out.println(String.format(
				"I am %d years old and graduated from Highschool in %d.  My Highschool mascot was the %s!", 46, 1986,
				"Red Dragons"));

		// String built-in methods
		System.out.println(hello.charAt(0));
		System.out.println("Match (ignore case)? " + (hello.compareToIgnoreCase("HEllO worLD") == 0));
		System.out.println(sixBackslash.length());
		System.out.println(hello.lastIndexOf('o'));
		String[] words = hello.split(" ");
		System.out.println(words[1]);
	}

}