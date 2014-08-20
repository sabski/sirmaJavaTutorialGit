package com.sirma.itt.javacourse.collections.task1.hashDice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.parser.Entity;

import com.sirma.itt.javacourse.Utils;

/**
 * Class that collects the statistics off the dice rollers.
 * 
 * @author simeon
 */
public class StatisticsCollector {

	private DiceRoller roller;
	private Map<DiceCombintionPair, List<Integer>> diceMap;

	/**
	 * Getter method for roller.
	 * 
	 * @return the roller
	 */
	public DiceRoller getRoller() {
		return roller;
	}

	/**
	 * Setter method for roller.
	 * 
	 * @param roller
	 *            the roller to set
	 */
	public void setRoller(DiceRoller roller) {
		this.roller = roller;
	}

	/**
	 * Getter method for diceMap.
	 * 
	 * @return the diceMap
	 */
	public Map<DiceCombintionPair, List<Integer>> getDiceMap() {
		return diceMap;
	}

	/**
	 * Setter method for diceMap.
	 * 
	 * @param diceMap
	 *            the diceMap to set
	 */
	public void setDiceMap(Map<DiceCombintionPair, List<Integer>> diceMap) {
		this.diceMap = diceMap;
	}

	/**
	 * Collects the data about the dice.
	 * 
	 * @param numberOfRolls
	 */
	public void collectData(int numberOfRolls) {
		DiceCombintionPair pair;

		for (int i = 0; i < numberOfRolls; i++) {
			pair = roller.rollDice();
			if (!diceMap.containsKey(pair)) {
				Utils.printConsoleMessage("Addind pair " + pair.toString());
				diceMap.put(pair, new ArrayList<Integer>());
			}
			List<Integer> map = diceMap.get(pair);
			map.add(i);
		}
	}

	/**
	 * Creates a default static collector.
	 * 
	 * @param sides
	 *            the sides of the dice that will be rolled.
	 */
	public StatisticsCollector(int sides) {
		diceMap = new HashMap<DiceCombintionPair, List<Integer>>();
		roller = new DiceRoller(sides);
	}

	/**
	 * prints in the console the gathered statistics
	 */
	public void printStatistics() {
		for (Entry<DiceCombintionPair, List<Integer>> en : diceMap.entrySet()) {
			Utils.printConsoleMessage("The combinathion " + en.getKey().getFirstNumber() + " "
					+ en.getKey().getSecondNumber() + " was rolled in " + en.getValue().toString());
		}
	}
}
