package edu.loudoun.jchs.exercises.chap3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Example of JUnit 4 test, using annotations (no need to extend TestCase)
 * @author scottnestor - TEALS, 2015
 *
 */
public class LeapYearTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsLeapYear() {
		assertFalse("Non Gregorian",LeapYear.isLeapYear(1581));
		assertTrue("Very first leap year",LeapYear.isLeapYear(1584));
		assertFalse("Century boundary",LeapYear.isLeapYear(1900));
		assertFalse("HS Graduation",LeapYear.isLeapYear(1986));
		assertTrue("400 year boundary",LeapYear.isLeapYear(1600));
		assertFalse("Inaugural TEALS volunteer",LeapYear.isLeapYear(2015));
	}

}
