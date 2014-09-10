package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

/**
 * Concrete implementation of {@link MyFactorys}
 * 
 * @author Simeon Iliev
 */
public class MyFactoryImpl extends MyFactory {

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
		// TODO Auto-generated method stub
		try {
			return (MyFactoryProduct) Class
					.forName(
							"com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProductImpl")
					.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
