package jchs2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class DiverseArrayTest {


	int [] arr = { 1,3,2,7,3 };
	int [][] arr2D = {{1,3,2,7,3 },{10,10,4,6,2},{5,3,5,9,6},{7,6,4,2,1}};
	int [][] arr2DX = {{1,1,5,3,4 },{12,7,6,1,9},{8,11,10,2,5},{3,2,3,0,6}};


	@Test
	public void testArraySum() {
		assertEquals("arraySum(int[])",16,DiverseArray.arraySum(arr));
	}

	@Test
	public void testRowSums() {
		assertTrue("rowSums(int[][])",Arrays.equals(new int[]{16,32,28,20},DiverseArray.rowSums(arr2D)));
	}

	@Test
	public void testIsDiverse() {
		assertTrue("isDiverse = true",DiverseArray.isDiverse(this.arr2D));
		assertFalse("isDiverse = false",DiverseArray.isDiverse(this.arr2DX));
	}

}
