package com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit;

import org.apache.log4j.Logger;

/**
 * Class for running the classinit sample.
 * 
 * @author simeon
 */
public class RunClassInit {

	private static Logger log = Logger.getLogger(RunClassInit.class.getName());

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
