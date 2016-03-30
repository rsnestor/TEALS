package jchs2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	
	private Range range = new Range(-3,2);

	@Test
	public void test() {
		assertTrue("Contains -3",range.contains(-3));
		assertFalse("No 3",range.contains(3));
		assertTrue("Contains 0",range.contains(0));
	}

}
