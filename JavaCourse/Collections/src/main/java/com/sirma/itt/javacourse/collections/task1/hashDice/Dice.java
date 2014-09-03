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
	 * @param sides
	 *            the sides to set
	 */
	public void setSides(int sides) {
		this.sides = sides;
	}

	/**
	 * Constructor for dice class that allows the user to enter the Dice sides.
	 * 
	 * @param sides
	 *            the sides of the dice that can be rolled.
	 */
	public Dice(int sides) {
		this.sides = sides;
	}

	/**
	 * Default constructor for Dice class that initializes a 6-sided dice.
	 */
	public Dice() {
		this.sides = 6;
	}

}
