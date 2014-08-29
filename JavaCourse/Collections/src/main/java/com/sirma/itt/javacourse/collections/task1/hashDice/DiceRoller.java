package com.sirma.itt.javacourse.collections.task1.hashDice;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.MathUtil;

/**
 * @author simeon
 */
public class DiceRoller {

	private Dice dice1;
	private Dice dice2;

	/**
	 * Getter method for dice1.
	 * 
	 * @return the dice1
	 */
	public Dice getDice1() {
		return dice1;
	}

	/**
	 * Setter method for dice1.
	 * 
	 * @param dice1
	 *            the dice1 to set
	 */
	public void setDice1(Dice dice1) {
		this.dice1 = dice1;
	}

	/**
	 * Getter method for dice2.
	 * 
	 * @return the dice2
	 */
	public Dice getDice2() {
		return dice2;
	}

	/**
	 * Setter method for dice2.
	 * 
	 * @param dice2
	 *            the dice2 to set
	 */
	public void setDice2(Dice dice2) {
		this.dice2 = dice2;
	}

	/**
	 * Rolls the dice and returns a pair that the dice rolled out.
	 * 
	 * @return the pair that was rowed.
	 */
	public DiceCombintionPair rollDice() {
		DiceCombintionPair pair = new DiceCombintionPair();
		pair.setPair(MathUtil.generateRandomNumberWithRange(1, dice1.getSides()),
				MathUtil.generateRandomNumberWithRange(1, dice2.getSides()));

		return pair;
	}

	/**
	 * Creates a dice roller with its own dice.
	 * 
	 * @param sides
	 *            the sides of the dices.
	 */
	public DiceRoller(int sides) {
		dice1 = new Dice(sides);
		dice2 = new Dice(sides);
	}

}
