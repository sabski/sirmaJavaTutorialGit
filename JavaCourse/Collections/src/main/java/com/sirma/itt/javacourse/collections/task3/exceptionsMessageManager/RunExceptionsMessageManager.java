package com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager;

import javax.naming.directory.InvalidAttributesException;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.MathUtil;

/**
 * Class that runs a sample of ExceptionsMessageManager.
 * 
 * @author simeon
 */
public class RunExceptionsMessageManager {

	private static Logger log = Logger.getLogger(RunExceptionsMessageManager.class.getName());

	/**
	 * Main method for the application.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		ExceptionsMessageManager manager = new ExceptionsMessageManager();
		User user = new User();

		// Start input for user name
		IOUtils.printConsoleMessage("Input user name :");
		user.setName(IOUtils.readValidatedLine(IOUtils.REGEX_VALIDATOR_LETHERS_ONLY));

		// Start input for user address
		IOUtils.printConsoleMessage("Input user address :");
		user.setAddress(IOUtils.readLine());

		// Start input for postal code
		IOUtils.printConsoleMessage("Input postal code for the new user :");
		int postalCode = IOUtils.readInt();
		if (!MathUtil.checkInputRange(1000, 9999, postalCode)) {
			IOUtils.printConsoleMessage("" + ExceptionsMessageManager.INVALID_POSTAL_CODE);
			try {
				manager.addExceptionMessage(ExceptionsMessageManager.INVALID_POSTAL_CODE);
			} catch (InvalidAttributesException e) {
				log.error("Invalid postal code", e);
			}
		} else {
			user.setPostalCode(postalCode);
		}

		// Start input for credit card number
		IOUtils.printConsoleMessage("Input card number :");
		String cardNumber = IOUtils.readLine();
		if (!cardNumber.matches(IOUtils.REGEX_VALIDATOR_CREDIT_CARD_NUMBERS_VISA)) {
			IOUtils.printConsoleMessage("" + ExceptionsMessageManager.INVALID_CARD_NUMBER);
			try {
				manager.addExceptionMessage(ExceptionsMessageManager.INVALID_CARD_NUMBER);
			} catch (InvalidAttributesException e) {
				log.error("Invalid credit card number", e);
			}
		} else {
			user.setCreditCardNumber(cardNumber);
		}

		// Start input for EGN
		IOUtils.printConsoleMessage("Input EGN : ");
		String EGN = IOUtils.readLine();
		if (EGN.length() != 10 || !EGN.matches(IOUtils.REGEX_VALIDATOR_NUMBERS_ONLY)) {
			IOUtils.printConsoleMessage("" + ExceptionsMessageManager.INVALID_EGN);
			try {
				manager.addExceptionMessage(ExceptionsMessageManager.INVALID_EGN);
			} catch (InvalidAttributesException e) {
				log.error("Invalid EGN", e);
			}
		} else {
			user.setEGN(Integer.parseInt(EGN));
		}
	}

}
