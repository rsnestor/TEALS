package jchs2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HiddenWordTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		HiddenWord hw = new HiddenWord("foobar");
		assertEquals("2 letter match","+oo+++",hw.getHint("oooooo"));
		assertEquals("1 letter contained","+*****",hw.getHint("buskey"));
		assertEquals("4 letter match","+oo+ar",hw.getHint("boofar"));
		assertEquals("bad length guess","",hw.getHint("boo"));
		assertEquals("exact match","foobar",hw.getHint("foobar"));
	}

}
