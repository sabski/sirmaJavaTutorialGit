package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations;

/**
 * Subtract command class holder.
 * 
 * @author Simeon Iliev
 */
public class SubtractCommand implements Command {

	private final static String SUBSTRACT_COMMAND = "-";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		return NumberOperations.subtractNumbers(firstNumber, secondNumber);
	}

	@Override
	public boolean isMyCommand(String command) {
		return command.equals(SUBSTRACT_COMMAND);
	}

}
