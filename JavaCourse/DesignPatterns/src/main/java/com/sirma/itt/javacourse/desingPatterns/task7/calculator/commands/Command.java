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
	 * @return the result if the command operation.
	 */
	public Double execute(Double firstNumber, Double secondNumber);

	/**
	 * Checks if that is command belongs to this command implementation.
	 * 
	 * @param command
	 *            the command string to verify that the commands match or not.
	 * @return true if the given command is the current commands command otherwise @return false.
	 */
	boolean isMyCommand(String command);
}
