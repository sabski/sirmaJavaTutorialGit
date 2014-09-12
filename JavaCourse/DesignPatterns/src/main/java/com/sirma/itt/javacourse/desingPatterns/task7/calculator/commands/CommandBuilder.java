package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

/**
 * Builder for Commands.
 * 
 * @author Simeon Iliev
 */
public class CommandBuilder {

	private CommandBuilder instance;

	/**
	 * Singleton type constructor
	 */
	private CommandBuilder() {
	}

	/**
	 * Getter for class instance;
	 * 
	 * @return the single instance of the class.
	 */
	public CommandBuilder getInstance() {
		if (instance == null) {
			instance = new CommandBuilder();
		}
		return instance;
	}
	
	
}
