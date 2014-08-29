package com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager;

import javax.naming.directory.InvalidAttributesException;

import com.sirma.itt.javacourse.IOUtils;

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
			IOUtils.printConsoleMessage(manager
					.addExceptionMessageUsingCode(ExceptionsMessageManager.FIRST));
			IOUtils.printConsoleMessage(manager
					.addExceptionMessageUsingCode(ExceptionsMessageManager.SECOND));
			IOUtils.printConsoleMessage(manager
					.addExceptionMessageUsingCode(ExceptionsMessageManager.THIRD));
			IOUtils.printConsoleMessage(manager
					.addExceptionMessageUsingCode(ExceptionsMessageManager.SECOND));
			IOUtils.printConsoleMessage(manager.getMesages(manager.getMesage()).toString());
			IOUtils.printConsoleMessage(manager
					.addExceptionMessage(ExceptionsMessageManager.INVALID_CARD_NUMBER));
			IOUtils.printConsoleMessage(manager
					.addExceptionMessage(ExceptionsMessageManager.INVALID_EGN));
			IOUtils.printConsoleMessage(manager
					.addExceptionMessage(ExceptionsMessageManager.INVALID_POSTAL_CODE));
			IOUtils.printConsoleMessage(manager.getMesages(manager.getMesage()).toString());
		} catch (InvalidAttributesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
