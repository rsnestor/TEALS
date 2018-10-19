package edu.loudoun.jchs;

/**
 * Superclass intended to encapsulate common code utilized throughout 
 * various exercises
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class CommandLineRunner {
	
	protected static void print(Object o) {
		System.out.print(o.toString());
	}
	
	protected static void println(Object o) {
		System.out.println(o.toString());
	}
	
	protected static void printf(String s, Object ... args) {
		System.out.printf(s,args);
	}
	
}
