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
public class ClassInformer {

	private final Logger log = Logger.getLogger(ClassInformer.class.getName());
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
		Class<?> classObject = myPrivateVariable.getClass();
		try {
			for (Field declearedField : classObject.getDeclaredFields()) {
				try {
					Field field = classObject.getDeclaredField(
							declearedField.getName().toString());
					field.setAccessible(true);
					Object obj = field.get(myPrivateVariable);
					IOUtils.printConsoleMessage(obj.toString());
				} catch (IllegalArgumentException | NoSuchFieldException ex) {
					log.error(ex.getMessage(), ex);
				}
			}
			for (Method methodM : classObject.getDeclaredMethods()) {
				try {
					IOUtils.printConsoleMessage(methodM.getName());
					int paramCount = methodM.getModifiers();
					IOUtils.printConsoleMessage("Parameter count = " + paramCount);
					Class<?>[] parameterTypes = methodM.getParameterTypes();
					Method method = classObject.getDeclaredMethod(methodM.getName(),
							parameterTypes);
					method.setAccessible(true);
					Object objectTwo = method.invoke(myPrivateVariable, params);
					IOUtils.printConsoleMessage(objectTwo.toString());
				} catch (IllegalArgumentException | NoSuchMethodException
						| InvocationTargetException ex) {
					log.error(ex.getMessage(), ex);
				}
			}
		} catch (SecurityException e) {
			log.error(e.getMessage(), e);
		}
	}

}
