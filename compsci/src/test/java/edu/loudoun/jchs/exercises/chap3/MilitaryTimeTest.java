/**
 * 
 */
package edu.loudoun.jchs.exercises.chap3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author scottnestor - TEALS, 2015
 *
 */
public class MilitaryTimeTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link edu.loudoun.jchs.exercises.chap3.MilitaryTime#parseTime(int)}.
	 */
	@Test
	public void testParseTime() {
		assertEquals("Midnight","12:00 AM",MilitaryTime.parseTime(0));
		assertEquals("Invalid",MilitaryTime.ILLEGAL,MilitaryTime.parseTime(-1));
		assertEquals("Noon","12:00 PM",MilitaryTime.parseTime(1200));
		assertEquals("030 hours","12:30 AM",MilitaryTime.parseTime(30));
		assertEquals("2359 hours","11:59 PM",MilitaryTime.parseTime(2359));
		assertEquals("235959 BAD",MilitaryTime.ILLEGAL,MilitaryTime.parseTime(235959));
		assertEquals("Midnight boundary","12:01 AM",MilitaryTime.parseTime(1));
		assertEquals("Afternoon boundary","12:01 PM",MilitaryTime.parseTime(1201));
		assertEquals("Bad minutes",MilitaryTime.ILLEGAL,MilitaryTime.parseTime(60));
	}

}
