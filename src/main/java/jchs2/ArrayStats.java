package jchs2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayStats {
	int rows = 0;
	int cols = 0;

	public ArrayStats(int[][] ary) {
		rows = ary.length;
		for (int row[] : ary) {
			cols = (cols < row.length) ? row.length : cols;
		}
	}

	public static ArrayStats getCoreStats(int[][] ary) {
		return new ArrayStats(ary);
	}

	/**
	 * Return a List of Integers, comprised of all the 2nd dimension values
	 * in column designated
	 * @param inAry Two dimensional int array
	 * @param col index of values to extract
	 * @return
	 */
	@SuppressWarnings("all")
	public static List<Integer> columnToList(final int[][] inAry, final int col) {
		return new ArrayList<Integer>() {
			{
				for (int row[] : inAry) {
					if (row.length>col){
						this.add(row[col]);
					}
				}
			}
		};
	}
	
	public static List <Integer> getRowList(int[][] inAry, int row) {
		return (inAry.length > row) ? Arrays.asList(ArrayUtils.toObject(inAry[row])):new <Integer>ArrayList();
	}
	
	/**
	 * Sort the given primitive array and return equivalent object List
	 * @param inAry
	 * @return
	 */
	public static List<Integer> sort(int[] inAry) {
		Arrays.sort(inAry);
		return Arrays.asList(ArrayUtils.toObject(inAry));
	}

	@Override
	public String toString() {
		return String.format("Array Stats:\nRows: %d\t(Max)Cols: %d\n", rows, cols);
	}
	
	public static String toString(List l) {
		String flatten = "[";
		for (Object o : l){
			flatten = flatten + o.toString() +',';
		}
		flatten = flatten + ']';
		return flatten;
	}
}
