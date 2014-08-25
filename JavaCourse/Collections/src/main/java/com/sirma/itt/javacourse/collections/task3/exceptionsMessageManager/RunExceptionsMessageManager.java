package com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager;

import javax.naming.directory.InvalidAttributesException;

import com.sirma.itt.javacourse.Utils;

/**
 * Class that runs a sample of ExceptionsMessageManager.
 * 
 * @author simeon
 */
public class RunExceptionsMessageManager {

	/**
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		ExceptionsMessageManager manager = new ExceptionsMessageManager();
		try {
			Utils.printConsoleMessage(manager
					.addExceptionMessageUsingCode(ExceptionsMessageManager.FIRST));
			Utils.printConsoleMessage(manager
					.addExceptionMessageUsingCode(ExceptionsMessageManager.SECOND));
			Utils.printConsoleMessage(manager
					.addExceptionMessageUsingCode(ExceptionsMessageManager.THIRD));
			Utils.printConsoleMessage(manager
					.addExceptionMessageUsingCode(ExceptionsMessageManager.SECOND));
			Utils.printConsoleMessage(manager.getMesages(manager.getMesage()).toString());
			Utils.printConsoleMessage(manager
					.addExceptionMessage(ExceptionsMessageManager.INVALID_CARD_NUMBER));
			Utils.printConsoleMessage(manager
					.addExceptionMessage(ExceptionsMessageManager.INVALID_EGN));
			Utils.printConsoleMessage(manager
					.addExceptionMessage(ExceptionsMessageManager.INVALID_POSTAL_CODE));
			Utils.printConsoleMessage(manager.getMesages(manager.getMesage()).toString());
		} catch (InvalidAttributesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
