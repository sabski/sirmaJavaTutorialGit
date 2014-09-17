package com.sirma.itt.javacourse.relectionAnotationRegex.test.task4.anotationSorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ChildAClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ChildBClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ChildCClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ComparatorAnnotaion;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ParrentClass;

/**
 * Unit test for annotation Sorting.
 * 
 * @author simeon
 */
public class AnotationSortingTest {

	private List<ParrentClass> list;
	private List<Object> result;

	/**
	 * Sets up the variables for the test.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<ParrentClass>();
		result = new ArrayList<Object>();

		ParrentClass p = new ParrentClass(1);
		ChildAClass a = new ChildAClass(2, "sad");
		ChildBClass b = new ChildBClass(3, 2.1f, "two");
		ChildCClass c = new ChildCClass(4, 2.14d, "three");

		list.add(a);
		list.add(c);
		list.add(b);
		list.add(p);
		// result adding
		result.add(p);
		result.add(a);
		result.add(b);
		result.add(c);

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ClassSorter#sort(java.util.List)}
	 * .
	 */
	@Test
	public void testSort() {
		Collections.sort(list, new ComparatorAnnotaion());
		assertEquals(result.toString(), list.toString());
	}

}
