package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations;

/**
 * Addition command class.
 * 
 * @author Simeon Iliev
 */
public class AddCommand implements Command {

	/**
	 * Executes the commands addition. {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		// TODO Auto-generated method stub
		return NumberOperations.additionNumbers(firstNumber, secondNumber);
	}

}
