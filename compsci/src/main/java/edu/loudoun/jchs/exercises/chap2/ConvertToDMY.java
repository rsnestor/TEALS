package edu.loudoun.jchs.exercises.chap2;

import java.util.Scanner;

import edu.loudoun.jchs.CommandLineRunner;

public class ConvertToDMY extends CommandLineRunner {

	private int yy, mm, dd = 0;

	public static void main(String[] args) {

		// Convert days to YYYYMMDD
		Scanner stdin = new Scanner(System.in);
		print("Enter days ");
		int days = stdin.nextInt();
		ConvertToDMY dateCon = new ConvertToDMY(days);
		print(String.format("%d years, %d months, %d days", dateCon.getYears(), dateCon.getMonths(), dateCon.getDays()));
		stdin.close();
	}

	/**
	 * Solution key concepts: 
	 * 1) integer (int) division always yields an integer 
	 * 2) ordering - calculate years, months, and days in order, adjusting the
	 * original days for every subsequent operation
	 * 
	 * Coding note: This implementation uses ternary expressions (a "short hand"
	 * if statement) => {logical check}?{true do}:{false do};
	 * 
	 * @param days
	 */
	public ConvertToDMY(int days) {
		//calc years
		yy = days / 365;
		// divide remaining days by 30
		mm = (days < 365) ? days / 30 : (days - (yy * 365)) / 30;
		// subtract years and months from days for remainder
		dd = (days - (yy * 365) - (mm * 30));
	}

	public int getYears() {
		return yy;
	}

	public void setYears(int yy) {
		this.yy = yy;
	}

	public int getMonths() {
		return mm;
	}

	public void setMonths(int mm) {
		this.mm = mm;
	}

	public int getDays() {
		return dd;
	}

	public void setDays(int dd) {
		this.dd = dd;
	}

}
