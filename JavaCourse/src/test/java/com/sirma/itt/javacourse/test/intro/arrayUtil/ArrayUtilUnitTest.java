package com.sirma.itt.javacourse.test.intro.arrayUtil;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.arrayUtil.ArrayUtil;

public class ArrayUtilUnitTest {

	private int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private ArrayUtil util = new ArrayUtil();

	@Test
	public void testPrint() {
		util.print(arr);
	}

	@Test
	public void testSum() {
		assertEquals(45, util.sum(arr));
	}

	@Test
	public void testGetMinElement() {
		assertEquals(1, util.getMinElement(arr));
	}

}
