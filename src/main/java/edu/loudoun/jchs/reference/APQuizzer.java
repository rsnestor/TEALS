package edu.loudoun.jchs.reference;

import java.util.Arrays;
import java.util.Random;

public class APQuizzer {

	public static void main(String[] args) {
		//1
		Random rand = new Random();
		int nums[] = new int[10];
		for (int i=0; i<10; i++){
			nums[i] = rand.nextInt(95) +5;
			//2 
			if (nums[i]%3==0){
				System.out.printf("%d ", nums[i]);
			}
		}
		System.out.println("\n");
		//3
		Arrays.sort(nums);
		//4
		String myString = "John Champe AP Computer Science focuses on Java";
		System.out.println(myString.substring(myString.lastIndexOf(' ')));
		//5
		System.out.println(myString.split(" ").length);
		//6
		int occr = 0;
		for (int i=0; i<myString.length(); i++) {
			occr += (myString.charAt(i)=='o') ? 1: 0;
		}
		System.out.println(occr);
	}
	
	
}
