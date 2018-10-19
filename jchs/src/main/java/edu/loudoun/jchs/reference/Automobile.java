package edu.loudoun.jchs.reference;

/**
 * Base class to begin demonstrating OO design techniques.
 * Key Concepts:
 * 1) Encapsulation
 * 2) static vs instance methods and variables
 * 3) Constructors
 * 4) Constants
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class Automobile {
	// protected (visible to subclasses)
	protected String make = "";
	protected String model = "";

	// constant (immutable)
	public static final int MIN_WHEEL_COUNT = 4;

	public static void main(String args[]) {
		// Create an instance
		Automobile ford = new Automobile("Ford", "Mustang");
		Automobile chevy = new Automobile("Chevrolet", "Camaro");

		// call instance method
		System.out.println("Mustang make: " + ford.getMake());
		System.out.println("Chevrolet model: " + chevy.getModel());

		// reference constant
		System.out.println("Automobile wheel minimum: " + Automobile.MIN_WHEEL_COUNT);

		// get the class
		System.out.println("Same class? " + (Automobile.class == ford.getClass()));
		System.out.println(chevy.getClass().getSimpleName()); // method chaining

		// compare objects
		System.out.println("Ford = Chevy? " + ford.equals(chevy));
	}

	public Automobile(String make, String model) {
		this.make = make;
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
