package com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit;


/**
 * Class for running the classinit sample.
 * 
 * @author simeon
 */
public class RunClassInit {

	/**
	 * Main method of the application.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {

		ClassInit init = new ClassInit();
		init.getClassHierhahyAndInterfaces("java.lang.String");
	}

}
