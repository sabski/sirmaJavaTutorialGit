package com.sirma.itt.javacourse.desing_patterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desing_patterns.task7.calculator.NumberOperations;

/**
 * Divide command class.
 * 
 * @author Simeon Iliev
 */
public class DivideCommand implements Command {

	private static final String DIVIDE_COMMAND = "/";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		return NumberOperations.divideNumbers(firstNumber, secondNumber);
	}

	@Override
	public boolean isMyCommand(String command) {
		return command.equals(DIVIDE_COMMAND);
	}
}
