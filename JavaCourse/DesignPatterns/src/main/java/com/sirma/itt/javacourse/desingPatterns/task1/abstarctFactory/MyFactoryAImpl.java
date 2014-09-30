package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

import org.apache.log4j.Logger;

/**
 * Factory for creating {@link MyFactoryProductAImpl} objects
 * 
 * @author Simeon Iliev
 */
public class MyFactoryAImpl extends MyFactory {

	private static Logger log = Logger.getLogger(MyFactoryAImpl.class.getName());
	private static MyFactoryAImpl instance = null;

	/**
	 * Private constructor.
	 */
	private MyFactoryAImpl() {
	}

	@Override
	public MyFactoryProduct createInstance() {
		return new MyFactoryProductAImpl();
	}

	@Override
	public MyFactoryProduct createInstanceByReflection() {
		try {
			return (MyFactoryProduct) Class
					.forName(
							"com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProductAImpl")
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

	public static MyFactoryAImpl getInstance() {
		if (instance == null) {
			instance = new MyFactoryAImpl();
		}
		return instance;
	}
}
