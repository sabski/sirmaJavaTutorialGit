package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.util.Comparator;

/**
 * @author simeon
 */
public class CompareAnnotaion implements Comparator<ParentClass> {

	@Override
	public int compare(ParentClass o1, ParentClass o2) {
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
