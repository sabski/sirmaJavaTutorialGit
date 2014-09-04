package com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that violates private methods via reflection.
 * 
 * @author simeon
 */
public class PrivateReflector {

	private MyPrivateClass myPrivateVariable;

	/**
	 * Method for displaying the private fields of a specific object.
	 * 
	 * @param params
	 *            the object which private fields should be displayed.
	 * @throws IllegalArgumentException
	 *             something went wrong.
	 * @throws IllegalAccessException
	 *             something went wrong.
	 * @throws SecurityException
	 *             something went wrong.
	 * @throws NoSuchFieldException
	 *             accessing invalid field.
	 * @throws NoSuchMethodException
	 *             invalid method Name.
	 * @throws InvocationTargetException
	 *             something went wrong.
	 * @throws InstantiationException
	 *             something went wrong.
	 */
	public void breakPrivateFields(Object... params) throws IllegalArgumentException,
			IllegalAccessException, SecurityException, NoSuchFieldException, NoSuchMethodException,
			InvocationTargetException, InstantiationException {

		myPrivateVariable = MyPrivateClass.class.newInstance();
		
		Class<?> cl = myPrivateVariable.getClass();

		for (Field f : cl.getDeclaredFields()) {
			Field field = myPrivateVariable.getClass().getDeclaredField(f.getName().toString());
			field.setAccessible(true);
			Object obj = field.get(myPrivateVariable);
			IOUtils.printConsoleMessage(obj.toString());
		}

		for (Method m : cl.getDeclaredMethods()) {
			IOUtils.printConsoleMessage(m.getName());
			int paramCount = m.getModifiers();
			IOUtils.printConsoleMessage("Parameter count = " + paramCount);
			Class<?>[] parameterTypes = m.getParameterTypes();
			Method method = myPrivateVariable.getClass().getDeclaredMethod(m.getName(),
					parameterTypes);
			method.setAccessible(true);
			String s = (String) method.invoke(myPrivateVariable, params);
			IOUtils.printConsoleMessage(s);

		}
	}

}
