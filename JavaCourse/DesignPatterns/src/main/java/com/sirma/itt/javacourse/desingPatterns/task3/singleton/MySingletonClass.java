package com.sirma.itt.javacourse.desingPatterns.task3.singleton;

/**
 * Singleton pattern class.
 * 
 * @author Simeon Iliev
 */
public class MySingletonClass {

	private static MySingletonClass instance = null;

	/**
	 * Private constructor.
	 */
	private MySingletonClass() {
		System.out.println("Singleton created");
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
