package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class that sorts classes with some criteria.
 * 
 * @author simeon
 */
public class ClassSorter {

	public List<Object> sort(List<ParentClass> list) {
		ParentClass[] p = new ParentClass[list.size()];
		for (int i = 0; i < list.size(); i++) {
			p[i] = list.get(i);
		}
		Arrays.sort(p, new CompareAnnotaion());
		List<Object> result = new ArrayList<Object>();
		result.addAll(Arrays.asList(p));
		return result;
	}

}
