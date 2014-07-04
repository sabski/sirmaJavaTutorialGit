package com.sirma.itt.javacourse.intro.randomGenerator;

/**
 * @author simeon
 */
public final class RunRandomStringGenerator {

	/**
	 * 
	 * @param args for the main method
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomStringGenerator randGen = new RandomStringGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(randGen.generateRandomString((i + 7) * 2));
		}

	}

	/**
	 * 
	 */
	private RunRandomStringGenerator(){
		
	}
}
