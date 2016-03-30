package jchs2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MultipleGroupsTest {

	private List<NumberGroup> groups = new ArrayList<NumberGroup>();

	@Before
	public void setUp() throws Exception {
		groups.add(new Range(5, 8));
		groups.add(new Range(10, 12));
		groups.add(new Range(1, 6));
	}

	@Test
	public void test() {
		MultipleGroups multi = new MultipleGroups(this.groups);
		assertTrue("Contains 2",multi.contains(2));
		assertFalse("No 9",multi.contains(9));
		assertTrue("Contains 6",multi.contains(6));
		assertFalse("No -1",multi.contains(-1));
	}

}
