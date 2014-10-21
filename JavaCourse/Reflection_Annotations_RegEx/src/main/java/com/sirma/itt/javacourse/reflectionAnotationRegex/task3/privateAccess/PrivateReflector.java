package com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that violates private methods via reflection.
 * 
 * @author simeon
 */
public class PrivateReflector {

	private final Logger log = Logger.getLogger(PrivateReflector.class.getName());
	private MyPrivateClass myPrivateVariable;

	/**
	 * Method for displaying the private fields of a specific object.
	 * 
	 * @param object
	 *            {@link MyPrivateClass} object instance.
	 * @param params
	 *            the object which private fields should be displayed.
	 * @throws IllegalAccessException
	 *             if the underlying field is inaccessible.
	 */
	public void showPrivateFields(MyPrivateClass object, Object... params)
			throws IllegalAccessException {

		myPrivateVariable = object;

		Class<?> cl = myPrivateVariable.getClass();

		try {

			for (Field f : cl.getDeclaredFields()) {
				try {
					Field field = myPrivateVariable.getClass().getDeclaredField(
							f.getName().toString());
					field.setAccessible(true);
					Object obj = field.get(myPrivateVariable);
					IOUtils.printConsoleMessage(obj.toString());
				} catch (IllegalArgumentException ex) {
					log.error(ex.getMessage(), ex);
				} catch (NoSuchFieldException ex) {
					log.error(ex.getMessage(), ex);
				}
			}

			for (Method m : cl.getDeclaredMethods()) {
				try {
					IOUtils.printConsoleMessage(m.getName());
					int paramCount = m.getModifiers();
					IOUtils.printConsoleMessage("Parameter count = " + paramCount);
					Class<?>[] parameterTypes = m.getParameterTypes();
					Method method = myPrivateVariable.getClass().getDeclaredMethod(m.getName(),
							parameterTypes);
					method.setAccessible(true);
					Object s = method.invoke(myPrivateVariable, params);
					IOUtils.printConsoleMessage(s.toString());
				} catch (IllegalArgumentException ex) {
					log.error(ex.getMessage(), ex);
				} catch (NoSuchMethodException e) {
					log.error(e.getMessage(), e);
				} catch (InvocationTargetException e) {
					log.error(e.getMessage(), e);
				}
			}
		} catch (SecurityException e) {
			log.error(e.getMessage(), e);
		}
	}

}
