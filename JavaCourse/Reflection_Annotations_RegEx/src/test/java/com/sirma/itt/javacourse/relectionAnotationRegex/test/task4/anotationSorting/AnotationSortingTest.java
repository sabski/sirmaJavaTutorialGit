package com.sirma.itt.javacourse.relectionAnotationRegex.test.task4.anotationSorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ChildAClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ChildBClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ChildCClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ClassSorter;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ComparatorAnnotaion;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ParrentClass;

/**
 * Unit test for annotation Sorting.
 * 
 * @author simeon
 */
public class AnotationSortingTest {

	private List<ParrentClass> list;
	private ClassSorter sort;
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

		ParrentClass p = new ParrentClass();
		ChildAClass a = new ChildAClass();
		ChildBClass b = new ChildBClass();
		ChildCClass c = new ChildCClass();

		list.add(a);
		list.add(c);
		list.add(b);
		list.add(p);
		sort = new ClassSorter();
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
		List<ParrentClass> temp = sort.sort(list, new ComparatorAnnotaion());
		assertEquals(result.toString(), temp.toString());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting.ClassSorter#sort(java.util.List)}
	 * .
	 */
	@Test(expected = NullPointerException.class)
	public void testSortWithNull() {
		sort.sort(null, null);
	}
}
