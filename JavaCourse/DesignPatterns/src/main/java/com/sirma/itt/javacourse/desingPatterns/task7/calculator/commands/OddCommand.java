package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

import com.sirma.itt.javacourse.desingPatterns.task7.calculator.NumberOperations;

/**
 * Odd function command implementation.
 * 
 * @author Simeon Iliev
 */
public class OddCommand implements Command {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		// TODO Auto-generated method stub
		return NumberOperations.oddFuncthion(firstNumber, secondNumber);
	}

}
