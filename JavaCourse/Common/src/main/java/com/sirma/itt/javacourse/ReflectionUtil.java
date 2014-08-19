package com.sirma.itt.javacourse;

import java.lang.reflect.Field;

/**
 * WARNING !!! This class uses reflection on object.
 * 
 * @author simeon
 */
public class ReflectionUtil {

	/**
	 * Method for comparing objects and there contents.
	 * 
	 * @param o1
	 *            first object
	 * @param o2
	 *            second object
	 * @return true if objects are equal.
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static boolean compareObjects(Object o1, Object o2) throws SecurityException,
			NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

		if (o1 == null || o2 == null) {
			return false;
		}

		if (!o1.getClass().equals(o2.getClass())) {
			return false;
		}

		Class<?> cl = o1.getClass();

		for (Field f : cl.getDeclaredFields()) {
			Field field = o1.getClass().getDeclaredField(f.getName().toString());
			field.setAccessible(true);
			Field field1 = o2.getClass().getDeclaredField(f.getName().toString());
			field1.setAccessible(true);

			Object obj = field.get(o1);
			Object obj1 = field1.get(o2);
			if (!obj.equals(obj1)) {
				return false;
			}
		}

		return true;
	}
}
