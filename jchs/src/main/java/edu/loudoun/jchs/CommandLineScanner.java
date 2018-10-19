package edu.loudoun.jchs;

import java.util.Scanner;

/**
 * Superclass intended to encapsulate command line user input (Scanner)
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class CommandLineScanner extends CommandLineRunner {
	
	static protected Scanner stdin = new Scanner(System.in);
	
	static protected synchronized int nextInt() {
		return stdin.nextInt();
	}
	
	static protected synchronized String next() {
		return stdin.next();
	}
	
	static protected synchronized Scanner getStdin() {
		return stdin;
	}
	
	@Override
	protected void finalize() throws Throwable {
		stdin.close();
	}
	
}
