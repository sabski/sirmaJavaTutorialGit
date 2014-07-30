package com.sirma.itt.javacourse.test.intro.task3.median;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.task3.median.FindArrayMedian;

/**
 * Unit test for the array median.
 * 
 * @author simeon
 */
public class FindArrayMedianUnitTest {

	/**
	 * Test if the median is found properly.
	 */
	@Test
	public void testFindMedian() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 4, 5, 99, -1, 5, 6 };
		FindArrayMedian find = new FindArrayMedian();
		assertEquals(4, find.findMedian(arr));
		// assertEquals(3, find.findMedian(arr2));
	}

	/**
	 * Test if the median is found properly.
	 */
	@Test
	public void testCalculateMedian() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 4, 5, 99, -1, 5, 6 };
		FindArrayMedian find = new FindArrayMedian();
		assertEquals(4, find.calculateMedian(arr));
		// assertEquals(3, find.calculateMedian(arr2));
	}

}
