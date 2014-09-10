package com.sirma.itt.javacourse.desingPatterns.task1.abstarctFactory;

/**
 * Factory for creating {@link MyFactoryProductAImpl} objects
 * 
 * @author Simeon Iliev
 */
public class MyFActoryAImpl extends MyFactory {

	private static MyFActoryAImpl instance = null;

	/**
	 * Private constructor.
	 */
	private MyFActoryAImpl() {
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

	public static MyFActoryAImpl getInstance() {
		if (instance == null) {
			instance = new MyFActoryAImpl();
		}
		return instance;
	}
}
