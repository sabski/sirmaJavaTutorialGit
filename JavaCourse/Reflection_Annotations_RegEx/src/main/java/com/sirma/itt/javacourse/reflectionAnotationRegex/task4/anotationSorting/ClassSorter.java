package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * A class that sorts classes with some criteria.
 * 
 * @author simeon
 */
public class ClassSorter {

	/**
	 * Method for sorting the a list of objects with a specific comparator.
	 * 
	 * @param <T>
	 *            Type of the class we are going to sort.
	 * @param list
	 *            the list that is to be sorted.
	 * @param comparator
	 *            the comparator we want to use for the sorting of the class.
	 * @return the sorted list off class objects.
	 */
	public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
		@SuppressWarnings("unchecked")
		T[] p = (T[]) Array.newInstance(Object.class, list.size());

		Arrays.sort(list.toArray(p), comparator);
		List<T> result = new ArrayList<T>();
		result.addAll(Arrays.asList(p));
		return result;
	}

}
