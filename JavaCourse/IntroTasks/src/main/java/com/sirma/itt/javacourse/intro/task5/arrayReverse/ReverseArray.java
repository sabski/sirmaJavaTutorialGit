package com.sirma.itt.javacourse.intro.task5.arrayReverse;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

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
	public List<Integer> reverseArray(List<Integer> arrayOfInts) {

		if (IOUtils.isNull(arrayOfInts)) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(-1);
			return res;
		}

		for (int i = 0; i < arrayOfInts.size() / 2; i++) {
			int tmp = arrayOfInts.get(i);
			arrayOfInts.set(i, arrayOfInts.get(arrayOfInts.size() - 1 - i));
			arrayOfInts.set(arrayOfInts.size() - 1 - i, tmp);
		}

		return arrayOfInts;
	}

}
