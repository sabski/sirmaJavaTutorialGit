package com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Inits a class by its name and shows his parents.
 * 
 * @author simeon
 */
public class ClassInit {

	/**
	 * @param path
	 *            the path to the object that is to be displayed its hierarchy.
	 * @return a new object instance.
	 * @throws InstantiationException
	 *             if this Class represents an abstract class, an interface, an array class, a
	 *             primitive type, or void; or if the class has no nullary constructor; or if the
	 *             instantiation fails for some other reason.
	 * @throws IllegalAccessException
	 *             if the class or its nullary constructor is not accessible.
	 * @throws ClassNotFoundException
	 *             if the class cannot be located
	 */
	public Object getClassHierhahyAndInterfaces(String path) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		Object obj = null;

		Class<?> init = Class.forName(path);
		obj = init.newInstance();
		for (Class<?> c : init.getDeclaredClasses()) {
			IOUtils.printConsoleMessage(c.getName());
		}

		for (Class<?> c : init.getInterfaces()) {
			IOUtils.printConsoleMessage(c.getName());
		}

		return obj;
	}
}
