package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

/**
 * Calculator command interface.
 * 
 * @author Simeon Iliev
 */
public interface Command {

	/**
	 * Executes the command implementation.
	 * 
	 * @return
	 */
	public Double execute(Double firstNumber, Double secondNumber);

	boolean isMyCommand(String command);
}
