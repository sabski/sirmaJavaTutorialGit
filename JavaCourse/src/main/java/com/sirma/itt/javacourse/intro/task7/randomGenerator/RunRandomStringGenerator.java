package com.sirma.itt.javacourse.intro.task7.randomGenerator;

import com.sirma.itt.javacourse.Utils;

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
		System.out.println("input the number of random string you want to generate.");
		int count = Utils.readLineNumber();
		for (int i = 0; i < count; i++) {
			System.out.println("Input String lenght :");
			int lenght = Utils.readLineNumber();
			System.out.println(randGen.generateRandomString(lenght));
		}

	}
}
