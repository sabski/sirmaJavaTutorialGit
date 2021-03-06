package com.sirma.itt.javacourse.desingpatterns.task1.abstractfactory;

import org.apache.log4j.Logger;

/**
 * Concrete implementation of {@link AbstractFactory}
 * 
 * @author Simeon Iliev
 */
public class Factory extends AbstractFactory {

	private static Logger log = Logger.getLogger(Factory.class);
	private static Factory instance = null;

	/**
	 * Private constructor.
	 */
	private Factory() {

	}

	@Override
	public MyProduct createInstance() {
		return new MyProduct();
	}

	@Override
	public MyProduct createInstanceByReflection(String className) {
		try {
			return (MyProduct) Class.forName(className).newInstance();
		} catch (ClassNotFoundException | IllegalAccessException
				| InstantiationException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Returns a single instance of {@link Factory}.
	 * 
	 * @return an instance of {@link Factory}
	 */
	public static Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}
}
