package com.sirma.itt.javacourse.collections.task1.hashDice;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Class for rolling of the dice 
 * 
 * @author simeon
 */
public class RunDice {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the method.
	 */
	public static void main(String[] args) {

		InputUtils.printConsoleMessage("Input dice sides.");
		StatisticsCollector collector = new StatisticsCollector(InputUtils.readInt());
		InputUtils.printConsoleMessage("Input number of rows");
		collector.collectData(InputUtils.readInt());
		collector.printStatistics();
	}

}
