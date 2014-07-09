package com.sirma.itt.javacourse.intro.randomGenerator;

import java.util.Scanner;

/**
 * Class for running the RandomString generator.
 * 
 * @author simeon
 */
public class RunRandomStringGenerator {

	/**
	 * @param args
	 *            for the main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomStringGenerator randGen = new RandomStringGenerator();
		Scanner scaner = new Scanner(System.in);
		System.out.println("input the number of random string you want to generate.");
		int count = scaner.nextInt();
		for (int i = 0; i < count; i++) {
			System.out.println("Input String lenght :");
			int lenght = scaner.nextInt();
			System.out.println(randGen.generateRandomString(lenght));
		}

	}
}
