package com.sirma.itt.javacourse.reflectionAnotationRegex.task3.privateAccess;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.StringUtil;

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
		InputUtils.printConsoleMessage("Input String value : ");
		String stringValue = InputUtils.readLine();
		InputUtils.printConsoleMessage("Input number value : ");
		int intValue = InputUtils.readInt();
		InputUtils.printConsoleMessage("Input float value : ");
		float floatValue = InputUtils.readFlaot();
		MyPrivateClass privateObject = new MyPrivateClass(intValue, stringValue, floatValue);
		InputUtils.printConsoleMessage("Input parameter value ");
		String s = InputUtils.readValidatedLine(StringUtil.REGEX_VALIDATOR_LETHERS_ONLY);
		try {
			reflector.showPrivateFields(privateObject, s);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}

	}

}
