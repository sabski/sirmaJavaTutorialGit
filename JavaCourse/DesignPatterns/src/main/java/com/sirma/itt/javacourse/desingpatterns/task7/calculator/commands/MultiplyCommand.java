package com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.NumberOperations;

/**
 * Multiply command command class.
 * 
 * @author Simeon Iliev
 */
public class MultiplyCommand implements Command {
	private final static String MULTIPLY_COMMAND = "*";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		return NumberOperations.multiplyNumbers(firstNumber, secondNumber);
	}

	@Override
	public boolean isMyCommand(String command) {
		return command.equals(MULTIPLY_COMMAND);
	}

}
