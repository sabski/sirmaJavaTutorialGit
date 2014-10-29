package com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Inits a class by its name and shows his parents.
 * 
 * @author simeon
 */
public class ClassInit {

	private static Logger log = Logger.getLogger(ClassInit.class);

	/**
	 * @param path
	 *            the path to the object that is to be displayed its hierarchy.
	 * @return a new object instance.
	 */
	public Object getClassHierhahyAndInterfaces(String path) {
		Object object = null;
		Class<?> classToBeInitieted = null;

		try {
			classToBeInitieted = Class.forName(path);
			object = classToBeInitieted.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			log.error(e.getMessage(), e);
		}
		for (Class<?> c : classToBeInitieted.getDeclaredClasses()) {
			IOUtils.printConsoleMessage(c.getName());
		}

		for (Class<?> c : classToBeInitieted.getInterfaces()) {
			IOUtils.printConsoleMessage(c.getName());
		}

		return object;
	}
}
