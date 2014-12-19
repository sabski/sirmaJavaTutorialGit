package com.sirma.itt.javacourse.desingpatterns.task2.fluentinterface;

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
