package com.sirma.itt.javacourse.desing_patterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desing_patterns.task7.calculator.NumberOperations;

/**
 * Odd function command implementation.
 * 
 * @author Simeon Iliev
 */
public class OddCommand implements Command {

	private static final String ODD_COMMAND = "^";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		return NumberOperations.oddFuncthion(firstNumber, secondNumber);
	}

	@Override
	public boolean isMyCommand(String command) {
		return command.equals(ODD_COMMAND);
	}

}
