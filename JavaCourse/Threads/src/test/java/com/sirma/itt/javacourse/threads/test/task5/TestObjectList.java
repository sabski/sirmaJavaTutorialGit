package com.sirma.itt.javacourse.threads.test.task5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.threads.task5.synchronizedStack.ObjectListSynchonized;

/**
 * Test class {@link ObjectListSynchonized}
 * 
 * @author Simeon Iliev
 */
public class TestObjectList {

	private ObjectListSynchonized list;

	/**
	 * Set up method.
	 * 
	 * @throws java.lang.Exception
	 *             something went wrong.
	 */
	@Before
	public void setUp() throws Exception {
		list = new ObjectListSynchonized(1);
	}

	/**
	 * Test method for Adding elements.
	 */
	@Test
	public void testAddElement() {
		assertTrue(list.addElement(2));
	}

	/**
	 * Test removing element.
	 */
	@Test
	public void testRemoveElement() {
		list.addElement(2);
		assertTrue(list.removeElement());
	}
}
