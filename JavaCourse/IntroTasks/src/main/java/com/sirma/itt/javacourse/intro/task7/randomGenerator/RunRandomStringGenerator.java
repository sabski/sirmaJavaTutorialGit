package com.sirma.itt.javacourse.intro.task7.randomGenerator;

import com.sirma.itt.javacourse.IOUtils;

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
		IOUtils.printConsoleMessage("Input the number of random string you want to generate.");
		int count = IOUtils.readInt();
		for (int i = 0; i < count; i++) {
			IOUtils.printConsoleMessage("Input String lenght :");
			int lenght = IOUtils.readInt();
			IOUtils.printConsoleMessage(randGen.generateRandomString(lenght));
		}

	}
}
