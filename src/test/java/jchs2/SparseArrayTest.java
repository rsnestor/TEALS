package jchs2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SparseArrayTest {

	private ArrayList<SparseArrayEntry> entries;
	
	@Before
	public void setUp() throws Exception {
		entries = new ArrayList<SparseArrayEntry>();
		entries.add(new SparseArrayEntry(1,4,4));
		entries.add(new SparseArrayEntry(2,0,1));
		entries.add(new SparseArrayEntry(3,1,-9));
		entries.add(new SparseArrayEntry(1,1,5));
	}

	@Test
	public void testGetValueAt() {
		SparseArray array = new SparseArray(entries);
		assertEquals("rows==4",4,array.getNumRows());
		assertEquals("cols==5",5,array.getNumCols());
		assertEquals("SparseArray[3][3] == 0",0,array.getValueAt(3,3));
		assertEquals("SparseArray[1][1] == 5",5,array.getValueAt(1,1));
	}
	
	@Test
	public void testRemoveColumn() {
		SparseArray array = new SparseArray(entries);
		//delete col 1
		array.removeColumn(1);
		assertEquals("rows==4",4,array.getNumRows());
		assertEquals("cols==4",4,array.getNumCols());		
		assertEquals("SparseArray[1][1] == 0",0,array.getValueAt(1,1));
		assertEquals("SparseArray[1][4] == 0",0,array.getValueAt(1,4));
		assertEquals("SparseArray[1][3] == 4",4,array.getValueAt(1,3));
		assertEquals("SparseArray[2][0] == 1",1,array.getValueAt(2,0));
	}

}
