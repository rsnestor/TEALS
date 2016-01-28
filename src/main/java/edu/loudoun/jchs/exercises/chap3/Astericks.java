package edu.loudoun.jchs.exercises.chap3;

import edu.loudoun.jchs.CommandLineRunner;

public class Astericks extends CommandLineRunner {

	private static char space = ' ';
	private static char asterisk = '*';
	
	public static void main(String[] args) {
		String line = "";
		//left lower right triangle
		Astericks.drawRepeatingChars(asterisk,space,1,10,10,10);
		//left top right triangle
		Astericks.drawRepeatingChars(asterisk,space,10,1,10,10);
		//right lower right triangle
		Astericks.drawRepeatingChars(space,asterisk,9,0,10,10);
		//two char split box
		Astericks.drawRepeatingChars('#',asterisk,9,0,10,10);
		//right top right triangle
		Astericks.drawRepeatingChars(space,asterisk,0,9,10,10);
		//diamond top
		Astericks.drawRepeatingChars(space,asterisk,6,0,7,7,1,false);
		//diamond bottom
		Astericks.drawRepeatingChars(space,asterisk,1,6,12,6,-1,true);
	}
	
	public static void drawRepeatingChars(char c1, char c2, int c1Start, int c1End, int width, int height) {
		drawRepeatingChars(c1, c2, c1Start, c1End, width, height,0,true);
	}
	
	/**
	 * Repeat the given two characters base on the W x H dimensions specified.
	 * 
	 * @param c1 1st character to display
	 * @param c2 2nd character to display
	 * @param c1Start 1st row repetitions of 1st char
	 * @param c1End last row repetitions of 1st char
	 * @param width width of drawing (cols)
	 * @param height height of drawing (rows)
	 * @param step dynamic width adjustment 
	 * @param cr final carriage return flag - after drawing is rendered
	 */
	public static void drawRepeatingChars(char c1, char c2, int c1Start, int c1End, int width, int height, int step, boolean cr) {
		int c1Pos = c1Start;
		for (int rows=1; rows<=height; rows++) {
			for (int cols=1; cols<=width; cols++) {
				print(cols<=c1Pos?c1:c2);
			}
			print('\n');
			c1Pos += (c1Pos>c1End)?-1:1;
			width+=step;
		}
		if (cr) print('\n');
	}

}
