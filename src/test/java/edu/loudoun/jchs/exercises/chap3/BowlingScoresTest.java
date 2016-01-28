package edu.loudoun.jchs.exercises.chap3;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class BowlingScoresTest extends TestCase {

	BowlingScores bs = new BowlingScores();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBadScores() {
		//boundary tests
		assertFalse("Negative Score",bs.bowl(-1));
		assertFalse("Negative Score",bs.bowl(301));
	}
	
	public void testAverageScores() {
		//whole numbers
		bs.reset();
		bs.bowl(200);
		assertEquals("Single Score",bs.avg(),200.0);
		bs.bowl(250);
		assertEquals("Two Scores",bs.avg(),225.0);
		bs.bowl(225);
		assertEquals("Three Scores",bs.avg(),225.0);
		bs.bowl(300);
		assertEquals("Perfect Game",bs.avg(),243.75);
		bs.bowl(0);
		assertEquals("Zilch",bs.avg(),195.0);
		bs.bowl(133);
		//Formatted rounding
		assertEquals("Round up",new DecimalFormat("###.##").format(bs.avg()),"184.67");
	}

}
