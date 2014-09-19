package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations;

/**
 * Divide command class.
 * 
 * @author Simeon Iliev
 */
public class DivideCommand implements Command {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		return NumberOperations.divideNumbers(firstNumber, secondNumber);
	}
}
