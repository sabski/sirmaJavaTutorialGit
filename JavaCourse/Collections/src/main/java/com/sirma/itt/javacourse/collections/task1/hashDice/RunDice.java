package com.sirma.itt.javacourse.collections.task1.hashDice;

import com.sirma.itt.javacourse.Utils;

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

		Utils.printConsoleMessage("Input dice sides.");
		StatisticsCollector collector = new StatisticsCollector(Utils.readInt());
		Utils.printConsoleMessage("Input number of rows");
		collector.collectData(Utils.readInt());
		collector.printStatistics();
	}

}
