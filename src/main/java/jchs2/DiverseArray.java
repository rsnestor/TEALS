package jchs2;

import java.util.ArrayList;
import java.util.List;

public class DiverseArray {
	
	public static int arraySum(int[] arr){
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		return sum;
	}
	
	public static int[] rowSums(int[][] arr2D) {
		int sums[] = new int[arr2D.length];
		for (int ix=0; ix<arr2D.length; ix++){
			sums[ix] = arraySum(arr2D[ix]);
		}
		return sums;
	}
	
	public static boolean isDiverse(int[][] arr2D){
		boolean isDiverse = true;
		List dList = new ArrayList();
		for (int sum : rowSums(arr2D)){
			isDiverse &= (!dList.contains(sum));
			dList.add(sum);
		}
		return isDiverse;
	}

}
