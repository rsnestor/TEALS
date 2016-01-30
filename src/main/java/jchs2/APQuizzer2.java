package jchs2;

import java.util.Arrays;
import java.util.Random;

public class APQuizzer2 {

	public static void main(String[] args) {
		//initialize
		int nums[][] = {{1,2,3},{5,7,7,1}};
		int sum = 0;
		int min = 0;
		for(int row = 0 ; row < nums.length; ++row) {
			 for(int column = 0; column<nums[row].length;++column) {
				//1
				sum += nums[row][column];
				System.out.printf("%d",sum);
				//2
				if (row==0 && column==0) {
					min = nums[row][column];
				} else if (min>nums[row][column]) {
					min = nums[row][column];
				}
				System.out.printf("%d",min);
			}
		}
	}	
	
}
