package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.util.Comparator;

/**
 * Custom comparator for our annotation and our classes that extend ParrentClass.
 * 
 * @author Simeon Iliev
 */
public class ComparatorAnnotaion implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		SortingAnotation anotation1 = o1.getClass().getAnnotation(SortingAnotation.class);
		SortingAnotation anotation2 = o2.getClass().getAnnotation(SortingAnotation.class);
		if (null == anotation1 || anotation2 == null) {
			return 1;
		}
		if (anotation1.weight() > anotation2.weight()) {
			return 1;
		} else if (anotation1.weight() < anotation2.weight()) {
			return -1;
		}
		return 0;
	}

}
