package com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager;

import javax.naming.directory.InvalidAttributesException;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.MathUtil;
import com.sirma.itt.javacourse.StringUtil;

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
		InputUtils.printConsoleMessage("Input user name :");
		user.setName(InputUtils.readValidatedLine(StringUtil.REGEX_VALIDATOR_LETHERS_ONLY));

		// Start input for user address
		InputUtils.printConsoleMessage("Input user address :");
		user.setAddress(InputUtils.readLine());

		// Start input for postal code
		do {
			InputUtils.printConsoleMessage("Input postal code for the new user :");
			int postalCode = InputUtils.readInt();
			if (!MathUtil.checkInputRange(1000, 9999, postalCode)) {
				InputUtils.printConsoleMessage("" + ExceptionsMessageManager.INVALID_POSTAL_CODE);
				try {
					manager.addExceptionMessage(ExceptionsMessageManager.INVALID_POSTAL_CODE);
				} catch (InvalidAttributesException e) {
					log.error("Invalid postal code", e);
				}
			} else {
				user.setPostalCode(postalCode);
			}
		} while (user.getPostalCode() == 0);
		// Start input for credit card number
		do {
			InputUtils.printConsoleMessage("Input card number :");
			String cardNumber = InputUtils.readLine();
			if (!cardNumber.matches(StringUtil.REGEX_VALIDATOR_CREDIT_CARD_NUMBERS_VISA)) {
				InputUtils.printConsoleMessage("" + ExceptionsMessageManager.INVALID_CARD_NUMBER);
				try {
					manager.addExceptionMessage(ExceptionsMessageManager.INVALID_CARD_NUMBER);
				} catch (InvalidAttributesException e) {
					log.error("Invalid credit card number", e);
				}
			} else {
				user.setCreditCardNumber(cardNumber);
			}
		} while (user.getCreditCardNumber() == null);

		// Start input for EGN
		do {
			InputUtils.printConsoleMessage("Input EGN : ");
			String EGN = InputUtils.readLine();
			if (EGN.length() != 10 || !EGN.matches(StringUtil.REGEX_VALIDATOR_NUMBERS_ONLY)) {
				InputUtils.printConsoleMessage("" + ExceptionsMessageManager.INVALID_EGN);
				try {
					manager.addExceptionMessage(ExceptionsMessageManager.INVALID_EGN);
				} catch (InvalidAttributesException e) {
					log.error("Invalid EGN", e);
				}
			} else {
				user.setEGN(Double.parseDouble(EGN));
			}
		} while (user.getEGN() == 0);
		InputUtils.printConsoleMessage("Errors durring input : " + manager.getMesage());
	}

}
