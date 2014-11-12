package com.sirma.itt.javacourse.intro.task7.randomGenerator;

import com.sirma.itt.javacourse.InputUtils;

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
		InputUtils.printConsoleMessage("Input the number of random string you want to generate.");
		int count = InputUtils.readInt();
		for (int i = 0; i < count; i++) {
			InputUtils.printConsoleMessage("Input String lenght :");
			int lenght = InputUtils.readInt();
			InputUtils.printConsoleMessage(randGen.generateRandomString(lenght));
		}

	}
}
