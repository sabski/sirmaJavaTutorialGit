package com.sirma.itt.javacourse.intro.arrayReverse;

import java.util.ArrayList;

/**
 * Class for reversing arrays of Integers.
 * 
 * @author simeon
 */
public class ReverseArray {

	/**
	 * Reverses an array of objects.
	 * 
	 * @param arrayOfInts
	 *            array to be reversed
	 * @return the reversed array
	 */
	public ArrayList<Integer> reverseArray(ArrayList<Integer> arrayOfInts) {

		for (int i = 0; i < arrayOfInts.size() / 2; i++) {
			int tmp = arrayOfInts.get(i);
			arrayOfInts.set(i, arrayOfInts.get(arrayOfInts.size() - 1 - i));
			arrayOfInts.set(arrayOfInts.size() - 1 - i, tmp);
		}

		return arrayOfInts;
	}

}
