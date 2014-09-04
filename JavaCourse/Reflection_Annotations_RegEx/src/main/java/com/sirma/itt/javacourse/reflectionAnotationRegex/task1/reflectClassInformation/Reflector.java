package com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that reflects a other class methods and fields.
 * 
 * @author simeon
 */
public class Reflector {

	/**
	 * Prints the Fields Methods of a given class.
	 * 
	 * @param object
	 *            the class that is going to be reflected.
	 * @throws IllegalAccessException
	 *             exception that may be triggered if there is illegal access to some parameters.
	 * @throws IllegalArgumentException
	 *             something went wrong
	 * @throws NoSuchFieldException
	 *             if we try to access a filed which is not there.
	 * @throws SecurityException
	 *             something went wrong
	 */
	public void reflect(Object object) throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {

		if (object == null) {
			IOUtils.printConsoleMessage("Object is null");
			return;
		}

		Class<?> reflecthionClass = object.getClass();
		IOUtils.printConsoleMessage(reflecthionClass.getName());

		for (Field f : reflecthionClass.getDeclaredFields()) {
			StringBuilder sb = new StringBuilder();
			Object c = "empty";
			Field field = object.getClass().getDeclaredField(f.getName().toString());
			switch (f.getModifiers()) {
				case 0:
					sb.append("");
					field.setAccessible(true);
					c = field.get(object);
					break;
				case 1:
					sb.append("public ");
					c = f.get(object);
					break;
				case 2:
					sb.append("private ");
					field.setAccessible(true);
					c = field.get(object);
					break;
				case 3:
					sb.append("default ");
					field.setAccessible(true);
					c = field.get(object);
					break;
				case 4:
					sb.append("protected ");
					field.setAccessible(true);
					c = field.get(object);
					break;
				default:
					break;
			}

			sb.append(f.getGenericType().toString() + " " + f.getName() + " = " + c.toString());
			IOUtils.printConsoleMessage(sb.toString());
		}

		for (Method m : reflecthionClass.getDeclaredMethods()) {
			IOUtils.printConsoleMessage(m.toString());
		}

	}

}
