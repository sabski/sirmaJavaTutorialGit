package com.sirma.itt.javacourse.collections.test.task1.hashDice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.collections.task1.hashDice.StatisticsCollector;

/**
 * JUnit test class for StatisticColector
 * 
 * @author simeon
 */
public class TestStatisticColector {

	private StatisticsCollector collector;
	private String result;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		collector = new StatisticsCollector(1);
		collector.collectData(10);
		result = "The combination 1 1 was rolled in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]\n";
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task1.hashDice.StatisticsCollector#prepareStringData()}
	 * .
	 */
	@Test
	public void testPrepareStringData() {
		assertEquals(result, collector.prepareStringData());
	}

}
