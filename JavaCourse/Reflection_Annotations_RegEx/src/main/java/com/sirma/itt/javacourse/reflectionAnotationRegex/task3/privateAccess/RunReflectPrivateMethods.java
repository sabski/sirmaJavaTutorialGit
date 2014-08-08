package com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess;

import java.lang.reflect.InvocationTargetException;

import com.sirma.itt.javacourse.Utils;

/**
 * Class that runs private method reflector.
 * 
 * @author simeon
 */
public class RunReflectPrivateMethods {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		PrivateReflector violator = new PrivateReflector();
		try {
			Utils.printConsoleMessage("Input parameter value ");
			String s = Utils.readValidatedLine(Utils.REGEX_VALIDATOR_LETHERS_ONLY);
			violator.violator(s);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}