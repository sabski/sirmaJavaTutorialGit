package com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sirma.itt.javacourse.Utils;

/**
 * Class that violates private methods via reflection.
 * 
 * @author simeon
 */
public class PrivateReflector {

	MyPrivateClass myPrivateVariable = new MyPrivateClass();

	public void violator(Object... params) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

		Class<?> cl = myPrivateVariable.getClass();
		
		for(Field f : cl.getDeclaredFields()){
			Field field = myPrivateVariable.getClass().getDeclaredField(f.getName().toString());
			field.setAccessible(true);
			Object obj = field.get(myPrivateVariable);
			Utils.printConsoleMessage(obj.toString());
		}
		
		
		for (Method m : cl.getDeclaredMethods()){
			Utils.printConsoleMessage(m.getName());
			int paramCount = m.getModifiers();
			Utils.printConsoleMessage("Parameter count = " + paramCount);
		    Class<?>[] parameterTypes =	m.getParameterTypes();
			Method method = myPrivateVariable.getClass().getDeclaredMethod(m.getName(),parameterTypes);
			method.setAccessible(true);
			String s = (String) method.invoke(myPrivateVariable, params);
			Utils.printConsoleMessage(s);
			
		}
	}



}
