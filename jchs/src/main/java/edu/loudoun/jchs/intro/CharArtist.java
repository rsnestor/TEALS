package edu.loudoun.jchs.intro;

import java.util.Arrays;
import java.util.List;

/**
 * Display ascii shapes/drawings on stdout
 * 
 * @author scottnestor - TEALS, 2015
 */
public class CharArtist {

	/**
	 * Problem solution key concepts: 
	 * Use System.out.println(String) to write a line to the console 
	 * 
	 * Coding notes: 
	 * 1) This implementation uses a static method "drawRectangle()" that
	 * accepts a boolean parameter to indicate whether the rectangle should be a border 
	 * only or solid.
	 * 2) An inner class is used to define the random character drawing.
	 *
	 */
	public static void main(String[] args) {
		System.out.println(CharArtist.drawRectangle(20, 15, '#'));
		System.out.println(CharArtist.drawRectangle(10, 25, '#', true));
		System.out.println(CharArtist.getAlien());
	}

	/**
	 * Solid rectangle
	 */
	public static String drawRectangle(int rows, int cols, char ch) {
		return drawRectangle(rows, cols, ch, false);
	}

	/**
	 * Draw rectangular border (if hollow == true)
	 * 
	 * @param rows
	 * @param cols
	 * @param ch
	 * @param hollow
	 * @return formatted String
	 */
	public static String drawRectangle(int rows, int cols, char ch, boolean hollow) {
		StringBuffer sb = new StringBuffer(rows * cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (hollow && (r > 0 && r < rows - 1) && (c > 0 && c < cols - 1)) {
					sb.append(' ');
				} else {
					sb.append(ch);
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	/**
	 * Factory method
	 *
	 * @return AsciiAlien instance
	 */
	public static AsciiAlien getAlien() {
		return new CharArtist().new AsciiAlien();
	}

	/**
	 * This is an inner class that utilizes an ArrayList to hold a 
	 * series of strings that comprise the character drawing
	 * 
	 * Note:  ascii art from http://www.asciiworld.com
	 *
	 */
	private class AsciiAlien {

        final List<String> alienData = Arrays.asList(
                "     (_\\     /_)",
                "       ))   ((",
                "     .-\"\"\"\"\"\"\"-.  ",
                " /^\\/  _.   _.  \\/^\\",
                " \\(   /__\\ /__\\   )/",
                "  \\,  \\o_/_\\o_/  ,/",
                "    \\    (_)    /",
                "     `-.'==='.-'",
                "      __) - (__   ",
                "     /  `~~~`  \\",
                "    /  /     \\  \\",
                "    \\ :       ; /",
                "     \\|==(*)==|/",
                "      :       :",
                "       \\  |  /",
                "     ___)=|=(___",
                "    {____/ \\____}"
                );

		/**
		 * Overload Object.toString()
		 */
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append('\n');
			for (String line : alienData) {
				sb.append(line);
				sb.append('\n');
			}
			sb.append('\n');
			return sb.toString();
		}
	}

}
