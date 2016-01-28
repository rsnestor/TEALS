package edu.loudoun.jchs.exercises.chap4;

import java.util.Scanner;

import edu.loudoun.jchs.CommandLineScanner;

public class GreatestCommonDivisor extends CommandLineScanner {

	public static void main(String[] args) {

        print("Type in two numbers and I will print outs its Greatest Common Divisor: ");
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        printf("GCD = %d\n",gcd (a, b));
    }

	static int gcd(int a, int b){
		if (a==0 || b==0) {
			return a+b;
		} else {
			return gcd(a,a%b);
		}
	}

}
