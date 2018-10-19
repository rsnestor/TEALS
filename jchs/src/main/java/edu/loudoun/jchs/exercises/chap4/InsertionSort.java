package edu.loudoun.jchs.exercises.chap4;

import java.util.Arrays;

import edu.loudoun.jchs.CommandLineRunner;

public class InsertionSort extends CommandLineRunner{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = {7,3,0,4,1};
		InsertionSort.insertionSort(ary);
		System.out.println(Arrays.toString(ary));
	}
	
	public static void insertionSort(int[] stuff) {
		for (int i=1; i<stuff.length; ++i) {
			int val = stuff[i];
			int j=i;
			while(j>0&&val<stuff[j-1]){
				stuff[j]=stuff[j-1];
				j--;
			}
			stuff[j]=val;
		}
	}


}
