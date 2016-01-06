package edu.loudoun.jchs.intro;

/**
 * Animal subclass
 *
 * @author scottnestor - TEALS, 2015
 *
 */
public class Dog extends Animal {

	public static void main(String[] args) {

		Dog fido = new Dog("Fido");
		System.out.println(fido);
		fido.bark((args.length > 0) ? Integer.parseInt(args[0]) : 3);
	}

	public Dog(String name) {
		super(name);
	}

	public void bark(int barks) {
		for (int i = 0; i < barks; i++) {
			System.out.print("woof"+((i==barks-1)?"!\n":", "));
		}
	}

}
