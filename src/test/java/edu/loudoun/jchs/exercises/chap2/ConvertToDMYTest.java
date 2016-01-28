package edu.loudoun.jchs.exercises.chap2;

import edu.loudoun.jchs.exercises.chap2.ConvertToDMY;
import junit.framework.TestCase;

public class ConvertToDMYTest extends TestCase {

	public ConvertToDMYTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testConvertToDMY() {
		//boundary 1
		ConvertToDMY ctd = new ConvertToDMY(365);
		assert(ctd.getYears()==1 && ctd.getMonths()==0 && ctd.getDays()==0);
		ctd = new ConvertToDMY(2738);
		assert(ctd.getYears()==7 && ctd.getMonths()==6 && ctd.getDays()==3);
		//boundary 2
		ctd = new ConvertToDMY(366);
		assert(ctd.getYears()==1 && ctd.getMonths()==0 && ctd.getDays()==1);
		//boundary 3
		ctd = new ConvertToDMY(396);
		assert(ctd.getYears()==1 && ctd.getMonths()==1 && ctd.getDays()==1);
		//boundary 4
		ctd = new ConvertToDMY(1);
		assert(ctd.getYears()==0 && ctd.getMonths()==0 && ctd.getDays()==1);
		
	}

}
