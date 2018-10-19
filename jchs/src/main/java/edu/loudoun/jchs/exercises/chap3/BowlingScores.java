/**
 * 
 */
package edu.loudoun.jchs.exercises.chap3;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Average integer numbers (representing bowling scores).
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class BowlingScores extends CommandLineRunner {
	
	int sum = 0;
	double games = 0.0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int score = 0;
		BowlingScores bs = new BowlingScores();
		while (score!=-999) {
			try {
			print("Enter bowling scores (-999 to quit): ");
			score = stdin.nextInt();
			if (score==-999) continue;
			if (!bs.bowl(score)){
				println("Invalid.");
			}
			} catch (InputMismatchException ime){
				println("Invalid.");
				break;
			}
		}
		printf("Average: %s\n",new DecimalFormat("###.##").format(bs.avg()));
		stdin.close();
	}
	
	public boolean bowl (int score){
		boolean ok=false;
		if (score>=0 && score<=300) {
			sum += score;
			games++;
			ok=true;
		}
		return ok;
	}
	
	public double avg() {
		return (games>0.0)?sum/games:games;
	}
	
	public void reset() {
		sum=0;
		games=0;
	}

}
