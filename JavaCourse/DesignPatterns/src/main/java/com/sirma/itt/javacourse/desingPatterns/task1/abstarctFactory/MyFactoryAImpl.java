package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

/**
 * Factory for creating {@link MyFactoryProductAImpl} objects
 * 
 * @author Simeon Iliev
 */
public class MyFactoryAImpl extends MyFactory {

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
		// TODO Auto-generated method stub
		try {
			return (MyFactoryProduct) Class
					.forName(
							"com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory.MyFactoryProductAImpl")
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

	public static MyFactoryAImpl getInstance() {
		if (instance == null) {
			instance = new MyFactoryAImpl();
		}
		return instance;
	}
}
