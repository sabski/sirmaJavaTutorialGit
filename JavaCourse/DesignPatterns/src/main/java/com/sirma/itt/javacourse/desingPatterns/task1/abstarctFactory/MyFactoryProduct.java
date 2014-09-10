package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

/**
 * Base product that is produced by {@link MyFactory}
 * 
 * @author Simeon Iliev
 */
public interface MyFactoryProduct {

	/**
	 * Prints Something in the console.
	 * 
	 * @param something
	 *            the value we want to say
	 * @return something
	 */
	public String saySomething(String something);

}
