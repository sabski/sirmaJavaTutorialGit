package com.sirma.itt.javacourse.collections.task1.hashDice;

/**
 * Class that contains a pair of rolled Dice.
 * 
 * @author simeon
 */
public class DiceCombintionPair {

	private int firstNumber;
	private int secondNumber;

	/**
	 * Getter method for firstNumber.
	 * 
	 * @return the firstNumber
	 */
	public int getFirstNumber() {
		return firstNumber;
	}

	/**
	 * Setter method for firstNumber.
	 * 
	 * @param firstNumber
	 *            the firstNumber to set
	 */
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	/**
	 * Getter method for secondNumber.
	 * 
	 * @return the secondNumber
	 */
	public int getSecondNumber() {
		return secondNumber;
	}

	/**
	 * Setter method for secondNumber.
	 * 
	 * @param secondNumber
	 *            the secondNumber to set
	 */
	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	/**
	 * Sets the Dice Pair that was rowed.
	 * 
	 * @param firstNumber
	 *            the first number that was thrown.
	 * @param secondNumber
	 *            the second number that was thrown.
	 */
	public void setPair(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		stackPair();
	}

	/**
	 * Stack the numbers in an orderly fashion.
	 */
	private void stackPair() {
		if (firstNumber > secondNumber) {
			int tmp = secondNumber;
			secondNumber = firstNumber;
			firstNumber = tmp;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return ((firstNumber * 10) + secondNumber) + "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		DiceCombintionPair pair = (DiceCombintionPair) obj;
		if (this.getFirstNumber() == pair.getFirstNumber()
				&& this.getSecondNumber() == pair.getSecondNumber()) {
			return true;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.firstNumber * 10 + this.secondNumber;
	}

}
