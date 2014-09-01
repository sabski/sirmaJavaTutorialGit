package com.sirma.itt.javacourse.test.objects.task4.homogeneousTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.task4.homogeneousTree.HomogeneousTree;
import com.sirma.itt.javacourse.objects.task4.homogeneousTree.TreeElement;

/**
 * @author simeon
 */
public class HomogeneousTreeTester {

	private HomogeneousTree<String> tree;
	private TreeElement<String> rootElement = new TreeElement<String>();

	/**
	 * @throws java.lang.Exception
	 *             something bad happens
	 */
	@Before
	public void setUp() throws Exception {
		tree = new HomogeneousTree<String>();
		rootElement.setElement("Hello worlds");
		tree.setRootElement(rootElement);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javalang.course.objects.task4.homogeneousTree.HomogeneousTree#printAllValues()}
	 * .
	 */
	@Test
	public void testPrintAllValues() {

		assertEquals("Hello worlds", tree.printAllValues());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task4.homogeneousTree.HomogeneousTree#addElement(com.sirma.itt.javacourse.objects.task4.homogeneousTree.TreeElement)}
	 * .
	 */
	@Test
	public void testAddElement() {
		// assertTrue(tree.addElement("Hello NASA"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task4.homogeneousTree.HomogeneousTree#addElement(java.lang.Object)}
	 * .
	 */
	@Test
	public void testAddEllemet() {
		/*
		 * TreeElement<String> element = new TreeElement<String>(); element.setElement("Hello");
		 * assertTrue(tree.addElement("Hello"));
		 */
	}

}
