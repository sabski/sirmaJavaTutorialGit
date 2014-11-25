package com.sirma.itt.javacourse.desing_patterns.task3.singleton;

import org.apache.log4j.Logger;

/**
 * Singleton pattern class.
 * 
 * @author Simeon Iliev
 */
public class MySingletonClass {

	private static Logger log = Logger.getLogger(MySingletonClass.class);
	private static MySingletonClass instance = null;

	/**
	 * Private constructor.
	 */
	private MySingletonClass() {
		log.info("Singleton created");
	}

	/**
	 * Creates a single instance of the class or returns the created one.
	 * 
	 * @return the instance of the class.
	 */
	public static MySingletonClass getInstance() {
		if (instance == null) {
			instance = new MySingletonClass();
		}
		return instance;
	}

}
