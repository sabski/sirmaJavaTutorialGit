package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

import org.apache.log4j.Logger;

/**
 * Concrete implementation of {@link MyFactorys}
 * 
 * @author Simeon Iliev
 */
public class MyFactoryImpl extends MyFactory {

	private static Logger log = Logger.getLogger(MyFactoryAImpl.class.getName());
	private static MyFactoryImpl instance = null;

	/**
	 * Private constructor.
	 */
	private MyFactoryImpl() {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MyFactoryProduct createInstance() {
		return new MyFactoryProductImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MyFactoryProduct createInstanceByReflection() {
		try {
			return (MyFactoryProduct) Class
					.forName(
							"com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProductImpl")
					.newInstance();
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Retruns a single instance of {@link MyFactoryImpl}.
	 * 
	 * @return an instance of {@link MyFactoryImpl}
	 */
	public static MyFactoryImpl getInstance() {
		if (instance == null) {
			instance = new MyFactoryImpl();
		}
		return instance;

	}
}
