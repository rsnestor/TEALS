package edu.loudoun.jchs.exercises.chap3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SlotMachineTest {

	SlotMachine sm = new SlotMachine();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	/**
	 * Evaluate if money has been allocated correctly for slot "plays"
	 * Two number match (winner) +2, 3 numbers (jackpot) +5 <br>
	 * IMPORTANT: Every play costs $0.50, regardless of the outcome
	 * <p>
	 * Repeating digits within the String (after a pull)
	 * will determine whether a winner or jackpot has occurred. 
	 * <br>
	 * Regex Explained: <br>
	 * . matches any character
	 * (...) creates a capturing group, to be referenced later
	 * (?=...) creates a lookahead, to look forwards in the input
	 * .*? matches anything between the character and its match (non-greedy matching)
	 * \\1 matches the first capturing group
	 */
	public void testPull() {
		double purse = sm.getOrigPurse();
		String display = "";
		String unique = "";
		for (int i=0; i<100; i++) {
			//test 100 "pulls"
			display = sm.pull();
			System.out.println(display);
			unique = display.replaceAll("(.)(?=.*?\\1)","");
			if (display.length()-unique.length()==2) {
				//winner $2.00 - $0.50 for the play
				assertTrue("Winner (+ $2.00)",(purse+1.50)==sm.getRunningPurse());
			} else if (display.length()-unique.length()==3) {
				//jackpot $5.00 - $0.50 for the play
				assertTrue("Winner (+ $5.00)",(purse+4.50)==sm.getRunningPurse());
			} else {
				//normal play, decrement $0.50
				assertTrue("Loser (- $0.50)",((purse>.5)?(purse-.50):0)==sm.getRunningPurse());
			}
			if (sm.busted()) sm.addMoney(20); //Add another $20 if busted
			purse = sm.getRunningPurse();
		};
		System.out.printf("Total gambled => %f\n",sm.getOrigPurse());
		System.out.printf("Walk away money => %f\n",sm.getRunningPurse());
	}

}
