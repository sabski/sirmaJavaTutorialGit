package com.sirma.itt.javacourse.desingPatterns.task5.proxy;

/**
 * The proxy class that responsible for the creation of new instances of integers.
 * 
 * @author Simeon Iliev
 */
public class IntegerProxy extends IntegerInterface{

	private IntegerFactory factory = IntegerFactory.getInstance();

	@Override
	public Integer loadInt() {

		
		return factory.createInstance();
	}

	
	
}
