package com.sirma.itt.javacourse.test.intro.arraySorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.arraySorting.QuickSortImpl;

/**
 * Unit test class for QuickSortImpl class.
 * 
 * @author simeon
 */
public class ArraySorting {

	private ArrayList<Integer> result = new ArrayList<Integer>();
	private ArrayList<Integer> arr = new ArrayList<Integer>();

	/**
	 * Unit test for QuickSortArray.
	 */
	@Test
	public void testQuickSortArray() {
		result.add(1);
		result.add(2);
		result.add(3);
		result.add(4);
		result.add(5);
		result.add(6);
		result.add(7);
		result.add(8);
		result.add(9);
		arr.add(5);
		arr.add(3);
		arr.add(9);
		arr.add(2);
		arr.add(8);
		arr.add(6);
		arr.add(4);
		arr.add(1);
		arr.add(7);
		QuickSortImpl impl = new QuickSortImpl();
		assertEquals(result, impl.quickSortArray(arr));
	}

}
