package com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class that runs private method reflector.
 * 
 * @author simeon
 */
public class RunReflectPrivateMethods {

	private static Logger log = Logger.getLogger(RunReflectPrivateMethods.class.getName());

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		ClassInformer reflector = new ClassInformer();
		IOUtils.printConsoleMessage("Input String value : ");
		String stringValue = IOUtils.readLine();
		IOUtils.printConsoleMessage("Input number value : ");
		int intValue = IOUtils.readInt();
		IOUtils.printConsoleMessage("Input float value : ");
		float floatValue = IOUtils.readFlaot();
		MyPrivateClass privateObject = new MyPrivateClass(intValue, stringValue, floatValue);
		IOUtils.printConsoleMessage("Input parameter value ");
		String s = IOUtils.readValidatedLine(IOUtils.REGEX_VALIDATOR_LETHERS_ONLY);
		try {
			reflector.showPrivateFields(privateObject, s);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}

	}

}
