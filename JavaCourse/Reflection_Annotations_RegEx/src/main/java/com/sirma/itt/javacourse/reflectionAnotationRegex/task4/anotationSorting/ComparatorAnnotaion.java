package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.util.Comparator;

/**
 * Custom comparator for our annotation and our classes that extend ParrentClass.
 * 
 * @author simeon
 */
public class ComparatorAnnotaion implements Comparator<ParrentClass> {

	@Override
	public int compare(ParrentClass o1, ParrentClass o2) {
		SortingAnotation anotation1 = o1.getClass().getAnnotation(SortingAnotation.class);
		SortingAnotation anotation2 = o2.getClass().getAnnotation(SortingAnotation.class);
		if (anotation1.weight() > anotation2.weight()) {
			return 1;
		} else if (anotation1.weight() < anotation2.weight()) {
			return -1;
		}
		return 0;
	}

}
