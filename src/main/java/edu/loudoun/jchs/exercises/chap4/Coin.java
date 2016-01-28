package edu.loudoun.jchs.exercises.chap4;

/**
 * Simulates a coin with two sides.
 *
 * @Author Lewis/Loftus/Cocking
 *
 */

public class Coin
{
	/**
	 * A possible value of the face of a coin.
	 */
	private final int HEADS = 0;
	
	/**
	 * A possible value of the face of a coin.
	 */
	private final int TAILS = 1;
	
	/**
	 * The side of a coin, either HEADS or TAILS.
	 */
	private int face;
	
	/**
	 * Creates a coin randomly to HEADS or TAILS.
	 */
	public Coin()
	{
		flip();
	} 
	
	/**
	 * Simulates a coin flip, randomly choosing HEADS or TAILS.
	 */
	public void flip()
	{
		face = (int)(Math.random() * 2);
	}
	
	
	/**
	 * Determines if the value of face is HEADS.
	 *
	 * @return true if the value of face is HEADS.
	 */
	public boolean isHeads()
	{
		return face == HEADS;
	}
	
	/**
	 * Returns a string with the name of the current face of the coin,
	 * either "Heads" or "Tails".
	 *
	 * @return the string with the name of the current face of the coin.
	 */
	public String toString()
	{
		String faceName;
		
		if (face == HEADS)
			faceName = "Heads";
		else
			faceName = "Tails";
		
		return faceName;
	}
}
