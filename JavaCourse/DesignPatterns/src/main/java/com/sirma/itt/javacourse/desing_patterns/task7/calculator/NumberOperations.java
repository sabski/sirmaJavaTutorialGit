package com.sirma.itt.javacourse.desing_patterns.task7.calculator;

/**
 * Class that contains various number operations.
 * 
 * @author Simeon Iliev
 */
public class NumberOperations {

	/**
	 * Adds two nubers together.
	 * 
	 * @param firstNumber
	 *            the first number to be used.
	 * @param secondNumber
	 *            the second number to be used.
	 * @return the result of the operation.
	 */
	public static Double additionNumbers(Double firstNumber, Double secondNumber) {
		return firstNumber + secondNumber;
	}

	/**
	 * Subtracts two nubers.
	 * 
	 * @param firstNumber
	 *            the first number to be used.
	 * @param secondNumber
	 *            the second number to be used.
	 * @return the result of the operation.
	 */
	public static Double subtractNumbers(Double firstNumber, Double secondNumber) {
		return firstNumber - secondNumber;
	}

	/**
	 * Multiplyes two nubers.
	 * 
	 * @param firstNumber
	 *            the first number to be used.
	 * @param secondNumber
	 *            the second number to be used.
	 * @return the result of the operation.
	 */
	public static Double multiplyNumbers(Double firstNumber, Double secondNumber) {
		return firstNumber * secondNumber;
	}

	/**
	 * Diveides two nubers.
	 * 
	 * @param firstNumber
	 *            the first number to be used.
	 * @param secondNumber
	 *            the second number to be used.
	 * @return the result of the operation.
	 */
	public static Double divideNumbers(Double firstNumber, Double secondNumber) {
		return firstNumber / secondNumber;
	}

	/**
	 * Calculates the odd functhion of the firstNumber.
	 * 
	 * @param firstNumber
	 *            the first number to be used.
	 * @param secondNumber
	 *            the second number to be used.
	 * @return the result of the operation.
	 */
	public static Double oddFuncthion(Double firstNumber, Double secondNumber) {
		return Math.pow(firstNumber, secondNumber);
	}
}
