package edu.loudoun.jchs.exercises.chap2;

import junit.framework.TestCase;

public class PhoneNumberTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test for area code format compliance
	 */
	public void testAreaCode() {
		//generate 100 random numbers and test the format
		for (int i = 0; i < 50; i++) {
			long tel = new PhoneNumber().generateRandomNumber();
			assertTrue("Telephone does not conform "+tel, tel >= 2002000000l);
			System.out.println(tel);
			int areaCode = Integer.parseInt(Long.toString(tel).substring(0, 3));
			assertTrue("Invalid area code "+areaCode, areaCode > 199 && areaCode < 799);
			int digit2 = Integer.parseInt(Integer.toString(areaCode).substring(1, 2));
			int digit3 = Integer.parseInt(Integer.toString(areaCode).substring(2, 3));
			assertTrue("Invalid area code "+areaCode, digit2 < 8 && digit3 < 8);
		}
	}

	/**
	 * Test prefix format compliance
	 */
	public void testPrefix() {
		//generate 100 random numbers and test the format
		for (int i = 0; i < 50; i++) {
			long tel = new PhoneNumber().generateRandomNumber();
			assertTrue("Telephone does not conform "+tel, tel >= 2002000000l);
			System.out.println(tel);
			int prefix = Integer.parseInt(Long.toString(tel).substring(3, 6));
			assertTrue("Invalid prefix "+prefix, prefix > 199);
			assertTrue("Invalid suffix "+tel, Long.toString(tel).substring(6).length() == 4);
		}
	}

	/**
	 * Test line number format compliance
	 */
	public void testLineNumber() {
		//generate 100 random numbers and test the format
		for (int i = 0; i < 50; i++) {
			long tel = new PhoneNumber().generateRandomNumber();
			assertTrue("Telephone does not conform "+tel, tel >= 2002000000l);
			System.out.println(tel);
			assertTrue("Invalid suffix "+tel, Long.toString(tel).substring(6).length() == 4);
		}
	}
	
}
