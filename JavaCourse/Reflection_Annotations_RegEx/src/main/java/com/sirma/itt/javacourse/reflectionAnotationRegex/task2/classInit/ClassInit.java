package com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit;

import java.io.ObjectInputStream.GetField;

import com.sirma.itt.javacourse.Utils;

/**
 * Inits a class by its name and shows his parents.
 * 
 * @author simeon
 */
public class ClassInit {

	/**
	 * @param path
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public Object getClassHierhahyAndInterfaces(String path) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		Object obj = null;

		Class<?> init = Class.forName(path);
		obj = init.newInstance();
		for (Class<?> c : init.getDeclaredClasses()) {
			Utils.printConsoleMessage(c.getName());
		}

		for (Class<?> c : init.getInterfaces()) {
			Utils.printConsoleMessage(c.getName());
		}

		return obj;
	}
}
