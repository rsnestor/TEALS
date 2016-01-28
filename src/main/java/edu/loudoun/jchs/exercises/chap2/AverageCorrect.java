package edu.loudoun.jchs.exercises.chap2;

import java.util.Scanner;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Key Concepts: 
 * 1) sum three integers and then divide by the number of terms 
 * 2) dividing by a double will yield a double
 * 
 * Implementation note: Used Scanner to prompt user for input (stdin). 
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class AverageCorrect extends CommandLineRunner {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int sum = 0;
		double terms = 3;
		//store the average in a double
		double avg = 0.0;
		println("Enter three integers");
		for (int i = 0; i < terms; i++) {
			print("> ");
			sum += stdin.nextInt();
		}
		avg = sum/terms;
		println("Average = " + avg);
		stdin.close();
	}

}
