package com.sirma.itt.javacourse.collections.task1.hashDice;

import com.sirma.itt.javacourse.IOUtils;

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

		IOUtils.printConsoleMessage("Input dice sides.");
		StatisticsCollector collector = new StatisticsCollector(IOUtils.readInt());
		IOUtils.printConsoleMessage("Input number of rows");
		collector.collectData(IOUtils.readInt());
		collector.printStatistics();
	}

}
