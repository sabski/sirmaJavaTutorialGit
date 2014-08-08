package com.sirma.itt.javacourse.exceptions.task3.objectList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import com.sirma.itt.javacourse.Utils;

public class ObjectListTest {

	private ObjectList list;
	private ObjectList list2;

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	@Before
	public void setUp() throws Exception {
		list = new ObjectList(15);
		list2 = new ObjectList();
	}

	@Test
	public void testAddElement() {
		assertTrue(list.addElement("52"));
	}

	@Test
	public void testRemoveElement() {
		list.addElement(12);
		assertTrue(list.removeElement());
	}

	@Test
	public void testRemoveElementAtIndex() {
		list.addElement(55);
		assertTrue(list.removeElementAtIndex(0));
	}

	@Test
	public void testRemoveElementByObject() {
		list.addElement(55);
		assertTrue(list.removeElementByObject(55));
	}

	@Test
	public void testPrintAllElements() {
		list.addElement(13);
		list.printAllElements();
		assertEquals("[ 13 ]\n", log.getLog());
	}

	@Test(expected = OverFlodException.class)
	public void testException() {
		for (int i = 0; i < 20; i++) {
			list.addElement("");
		}
	}

	@Test
	public void testEmptySearch() {
		
		assertFalse(list.removeElementByObject(""));
	}
	
	@Test(expected = NegativeIndexException.class)
	public void testNegativeIndex(){
		list.removeElementAtIndex(-2);
	}
	
	@Test(expected = NegativeIndexException.class)
	public void testIndexOutOfBounds(){
		list.removeElementAtIndex(222);
	}
	
	@Test(expected = NegativeIndexException.class)
	public void testRemoveElementException(){
		list.removeElement();
	}
}
