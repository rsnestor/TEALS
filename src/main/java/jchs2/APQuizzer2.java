package jchs2;

import java.util.ArrayList;
import java.util.Arrays;

public class APQuizzer2 {

	public static void main(String[] args) {
		// initialize
		int nums[][] = { { 3, 1, 2 }, { 5, 7, 7, 1 } };
		int sum = 0;
		int min = nums[0][0];
		for (int row = 0; row < nums.length; ++row) {
			for (int column = 0; column < nums[row].length; ++column) {
				// 1 sum all values
				sum += nums[row][column];
				// 2 min of all values
				if (min > nums[row][column]) {
					min = nums[row][column];
				}
			}
		}
		System.out.printf("Sum = %d\n", sum);
		System.out.printf("Min = %d\n", min);
		//3 array stats (rows & cols)
		System.out.println(ArrayStats.getCoreStats(nums));
		//4 list for col and row specified
		System.out.println(ArrayStats.columnToList(nums, 2));
		System.out.println(ArrayStats.getRowList(nums, 1));
		//5 sorted list from array
		System.out.println(ArrayStats.sort(nums[0]));
	}
		
}
