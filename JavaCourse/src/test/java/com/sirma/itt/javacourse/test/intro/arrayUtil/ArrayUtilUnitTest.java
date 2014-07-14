package com.sirma.itt.javacourse.test.intro.arrayUtil;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.task2.arrayUtil.ArrayUtil;

/**
 * Unit test for the ArrayUtil class.
 * 
 * @author simeon
 */
public class ArrayUtilUnitTest {

	private int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private ArrayUtil util = new ArrayUtil();

	/**
	 * Test the print functionality of the ArrayUtil class.
	 */
	@Test
	public void testPrint() {
		util.print(arr);
	}

	/**
	 * Test the sum functionality of the ArrayUtil class.
	 */
	@Test
	public void testSum() {
		assertEquals(45, util.sum(arr));
	}

	/**
	 * Test the functionality to get the smallest element of the ArrayUtil class.
	 */
	@Test
	public void testGetMinElement() {
		assertEquals(1, util.getMinElement(arr));
	}

}
