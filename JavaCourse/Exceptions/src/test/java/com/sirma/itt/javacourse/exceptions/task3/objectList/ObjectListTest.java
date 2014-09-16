package com.sirma.itt.javacourse.exceptions.task3.objectList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

/**
 * JUnit test class for {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList}
 * 
 * @author Simeon Iliev
 */
public class ObjectListTest {

	private ObjectList list;

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	/**
	 * Sets up variables for testing.
	 * 
	 * @throws Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		list = new ObjectList(15);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#addElement(Object)}
	 */
	@Test
	public void testAddElement() {
		assertTrue(list.addElement("52"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#removeElement()}
	 */
	@Test
	public void testRemoveElement() {
		list.addElement(12);
		assertTrue(list.removeElement());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#removeElementAtIndex(int)}
	 */
	@Test
	public void testRemoveElementAtIndex() {
		list.addElement(55);
		assertTrue(list.removeElementAtIndex(0));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#removeElementByObject(Object)}
	 */
	@Test
	public void testRemoveElementByObject() {
		list.addElement(55);
		assertTrue(list.removeElementByObject(55));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#printAllElements()}
	 */
	@Test
	public void testPrintAllElements() {
		list.addElement(13);
		list.printAllElements();
		assertTrue(log.getLog().contains("13"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#addElement(Object)}
	 */
	@Test(expected = OverFlodException.class)
	public void testException() {
		for (int i = 0; i < 20; i++) {
			list.addElement("");
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#removeElementByObject(Object)}
	 */
	@Test
	public void testEmptySearch() {
		assertFalse(list.removeElementByObject(""));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#removeElementAtIndex(int)}
	 */
	@Test(expected = NegativeIndexException.class)
	public void testNegativeIndex() {
		list.removeElementAtIndex(-2);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#removeElementAtIndex(int)}
	 */
	@Test(expected = NegativeIndexException.class)
	public void testIndexOutOfBounds() {
		list.removeElementAtIndex(222);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.exceptions.task3.objectList.ObjectList#removeElement()}
	 */
	@Test(expected = NegativeIndexException.class)
	public void testRemoveElementException() {
		list.removeElement();
	}
}
