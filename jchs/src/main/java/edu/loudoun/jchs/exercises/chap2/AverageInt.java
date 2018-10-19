package edu.loudoun.jchs.exercises.chap2;

import java.util.Scanner;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Key Concepts: 
 * 1) sum three integers and then divide by the number of terms 
 * 2) integer division yields an integer (fractions are ignored)
 * 
 * Implementation note: Used Scanner to prompt user for input (stdin). 
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class AverageInt extends CommandLineRunner {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int sum = 0;
		int terms = 3;
		println("Enter three integers");
		for (int i = 0; i < terms; i++) {
			print("> ");
			sum += stdin.nextInt();
		}
		println("Average = " + sum / terms);
		stdin.close();
	}

}
