package edu.loudoun.jchs.exercises.chap2;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Solution key concepts: 
 * 1) Strings have a rich API built-in
 * 2) Index methods are zero based
 * 3) String.replace(...) provides a COPY of the original String
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class StringManipulation2 extends CommandLineRunner {

	public static void main(String[] args) {
		//Setup three Strings
		String test = "This is a test.";
		String announce = "For the next sixty seconds we will conduct a test of the emergency broadcast system.";
		String close = "This is only a test.";
		
		printf("announce.charAt(27) %c\n",announce.charAt(27));
		//Concatenate to create a new String
		String msg = test.concat(announce).concat(close);
		println(msg);
		printf("announce.equals(msg) %b\n",announce.equals(msg));
		//compareTo == 0 if Strings are equal
		printf("announce.compareTo(close) %d\n",announce.compareTo(close));
		String closeLower = "this is only a test.";
		printf("close.equals(closeLower) %b\n",close.equals(closeLower));
		printf("close.equalsIgnoreCase(closeLower) %b\n",close.equalsIgnoreCase(closeLower));
		printf("test.contains(\"he\") %b\n",test.contains("he"));
		printf("announce.contains(\"he\") %b\n",announce.contains("he"));
		//re-assign announce String with substitution
		announce = announce.replaceAll("he", "xyzzy");
		printf("announce.replace(\"he\",\"xyzzy\") %s\n",announce);
		printf("test.length() %d\n",test.length());
		//substring from 2nd position (zero based index)
		printf("test.substring(1) %s\n",test.substring(1));
		//substring 2nd to 10th position
		printf("announce.substring(1,11) %s\n",announce.substring(1,11));
	}

}
