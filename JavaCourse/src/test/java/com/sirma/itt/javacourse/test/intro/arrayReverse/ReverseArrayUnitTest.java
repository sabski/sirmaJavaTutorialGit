package com.sirma.itt.javacourse.test.intro.arrayReverse;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.arrayReverse.ReverseArray;

/**
 * Unit test class for ReverseArray.
 * 
 * @author simeon
 */
public class ReverseArrayUnitTest {

	private ArrayList<Integer> result = new ArrayList<Integer>();
	private ArrayList<Integer> arr = new ArrayList<Integer>();

	/**
	 * Unit test for the ReverseArray.
	 */
	@Test
	public void testReverseArray() {
		result.addAll(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));
		arr.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		ReverseArray rev = new ReverseArray();
		assertEquals(result, rev.reverseArray(arr));
	}

}
