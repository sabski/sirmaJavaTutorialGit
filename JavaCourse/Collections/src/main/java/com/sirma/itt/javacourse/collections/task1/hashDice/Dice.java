package com.sirma.itt.javacourse.collections.task1.hashDice;
/**
 * M-sided dice that can be rolled. 
 * 
 * @author simeon
 */
public class Dice {

	private int sides;

	/**
	 * Getter method for sides.
	 *
	 * @return the sides
	 */
	public int getSides() {
		return sides;
	}

	/**
	 * Setter method for sides.
	 *
	 * @param sides the sides to set
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}

	/**
	 * @param sides
	 */
	public Dice(int sides) {
		this.sides = sides;
	}


	/**
	 * @param sides
	 */
	public Dice() {
		this.sides = 6;
	}

}
