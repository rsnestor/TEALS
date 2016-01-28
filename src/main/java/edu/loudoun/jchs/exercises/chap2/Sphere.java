package edu.loudoun.jchs.exercises.chap2;

import java.text.DecimalFormat;
import java.util.Scanner;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Solution keys:
 * 1) Use of Math.PI (static) value
 * 2) Use of DecimalFormat class
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class Sphere extends CommandLineRunner {

	double radius = 0;
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		//prompt for radius
		print("Enter radius > ");
		//create a sphere instance
		Sphere sphere = new Sphere(stdin.nextDouble());
		DecimalFormat fmt = new DecimalFormat("0.0000");
		printf("Volume = %s\n",fmt.format(sphere.getVolume()));
		printf("Area = %s\n",fmt.format(sphere.getArea()));
		stdin.close();
	}
	
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	public double getVolume() {
	    //use the PI constant from the Math class
		return 4/3.0*(Math.PI*(Math.pow(radius, 3)));
	}
	
	public double getArea() {
		return 4.0*(Math.PI*(Math.pow(radius, 2)));
	}
	
}
