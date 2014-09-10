package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

/**
 * An abstract Factory Interface.
 * 
 * @author Simeon Iliev
 */
public abstract class MyFactory {

	/**
	 * Creates a new instance of a {@link MyFactoryProduct} using default constructor.
	 * 
	 * @return a new {@link MyFactoryProduct} object
	 */
	abstract public MyFactoryProduct createInstance();

	/**
	 * Creates a new instance of a {@link MyFactoryProduct} by using reflection
	 * 
	 * @return a new {@link MyFactoryProduct} object
	 */
	abstract public MyFactoryProduct createInstanceByReflection();

}
