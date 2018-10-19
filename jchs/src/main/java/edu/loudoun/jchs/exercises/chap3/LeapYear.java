/**
 * 
 */
package edu.loudoun.jchs.exercises.chap3;

import java.util.Scanner;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Determine leap year based on the following algorithm:
 * <b>evenly divisible by 4 but not 100 (unless evenly by 400)</b>
 * 
 * Key concepts: modulo division
 *   
 * @author scottnestor - TEALS, 2015
 *
 */
public class LeapYear extends CommandLineRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		println("Leap year determination.  Enter year below, greater than 1582 (0 to quit):");
		int yr=0;
		Scanner stdin = new Scanner(System.in);
		do {
		print("Year: ");
		yr = stdin.nextInt();
		println(LeapYear.isLeapYear(yr)?"Yes":"No");
		} while (yr!=0);
		stdin.close();
	}
	
	/**
	 * Leap year algorithm:<br>
	 * Year is &gt;= 1582 and evenly divisible by 4, but NOT by 100 (except for 400)
	 * @param yr
	 * @return
	 */
	public static boolean isLeapYear(int yr) {
		boolean leap = false;
		if (yr>1581 && yr%4==0) {
			if (yr%100 !=0 || yr%400==0) {
				leap = true;
			}
		}
		return leap;
		//printf("%d %d %d\n",yr%4,yr%100,yr%400);		
	}

}
