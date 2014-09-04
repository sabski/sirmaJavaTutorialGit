package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation class for sorting classes.
 * 
 * @author simeon
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SortingAnotation {
	/**
	 * Annotation value that lets us weigh classes that are annotated with it.
	 */
	int weight();

}
