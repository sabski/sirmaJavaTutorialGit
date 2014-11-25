package com.sirma.itt.javacourse.desing_patterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desing_patterns.task7.calculator.NumberOperations;

/**
 * Addition command class.
 * 
 * @author Simeon Iliev
 */
public class AddCommand implements Command {

	private static final String ADD_COMMAND = "+";

	/**
	 * Executes the commands addition. {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		return NumberOperations.additionNumbers(firstNumber, secondNumber);
	}

	@Override
	public boolean isMyCommand(String command) {
		return command.equals(ADD_COMMAND);
	}
}
