package com.sirma.itt.javacourse.desingPatterns.task2.fluentInterface;

/**
 * Runner class.
 * 
 * @author Simeon Iliev
 */
public class RunMail {

	/**
	 * Main method for the Fluent interface test.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		MailFluentConstruct mailConstructor = new MailFluentConstruct();
		mailConstructor.createNewMailFromTo("simeon", "hristo").attachFile(null).send();

	}

}
