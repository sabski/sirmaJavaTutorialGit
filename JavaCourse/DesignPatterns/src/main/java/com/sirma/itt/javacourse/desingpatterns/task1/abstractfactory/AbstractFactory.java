package com.sirma.itt.javacourse.desingpatterns.task1.abstractfactory;

/**
 * An abstract Factory.
 * 
 * @author Simeon Iliev
 */
public abstract class AbstractFactory {

	/**
	 * Creates a new instance of a {@link MyProduct} using default constructor.
	 * 
	 * @return a new {@link MyProduct} object
	 */
	abstract public MyProduct createInstance();

	/**
	 * Creates a new instance of a {@link MyProduct} by using reflection
	 * 
	 * @param className
	 *            the name of the class we want to create.
	 * @return a new {@link MyProduct} object or null if an error has occurred.
	 */
	abstract public MyProduct createInstanceByReflection(String className);

}
