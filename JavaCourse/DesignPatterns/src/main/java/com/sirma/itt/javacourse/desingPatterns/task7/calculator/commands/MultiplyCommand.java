package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations;

/**
 * Multiply command command class.
 * 
 * @author Simeon Iliev
 */
public class MultiplyCommand implements Command {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		return NumberOperations.multiplyNumbers(firstNumber, secondNumber);
	}

}
