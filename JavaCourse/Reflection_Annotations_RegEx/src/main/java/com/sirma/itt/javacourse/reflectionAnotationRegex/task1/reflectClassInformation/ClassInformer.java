package com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that reflects a other class methods and fields.
 * 
 * @author Simeon Iliev
 */
public class ClassInformer {

	private static Logger log = Logger.getLogger(ClassInformer.class);

	/**
	 * Prints the Fields Methods of a given class.
	 * 
	 * @param object
	 *            the class that is going to be reflected.
	 * @return a string with the information of the class.
	 */
	public String getObjectFieldsAndMethods(Object object) {
		
		Class<?> reflecthionClass = object.getClass();
		IOUtils.printConsoleMessage(reflecthionClass.getName());
		StringBuilder stringBuilder = new StringBuilder();
		for (Field filedF : reflecthionClass.getDeclaredFields()) {
			Object tempObject = "empty";
			Field field = null;
			try {
				field = object.getClass().getDeclaredField(filedF.getName().toString());
			} catch (NoSuchFieldException | SecurityException e) {
				log.error(e.getMessage(), e);
			}
			try {
				switch (filedF.getModifiers()) {
					case 1:
						stringBuilder.append("public ");
						tempObject = filedF.get(object);
						break;
					case 2:
						stringBuilder.append("private ");
						field.setAccessible(true);
						tempObject = field.get(object);
						break;
					case 4:
						stringBuilder.append("protected ");
						field.setAccessible(true);
						tempObject = field.get(object);
						break;
					default:
						break;
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				log.error(e.getMessage(), e);
			}
			stringBuilder.append(filedF.getGenericType().toString() + " " + filedF.getName() + " = " + tempObject.toString());
			log.info(stringBuilder.toString());
		}
		for (Method method : reflecthionClass.getDeclaredMethods()) {
			log.info(method.toString());
			stringBuilder.append(method.toString());
		}
		return stringBuilder.toString();
	}

}
