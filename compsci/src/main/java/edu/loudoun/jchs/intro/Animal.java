package edu.loudoun.jchs.intro;

/**
 * Animal base class
 *
 * @author scottnestor - TEALS, 2015
 *
 */
public class Animal {

	private String nm = "";

	public Animal() {
		super();
	}

	public Animal(String name) {
		this.nm = name;
	}

	public String toString() {
		return "Hello, my name is " + nm;
	}

}
