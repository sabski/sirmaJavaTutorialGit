package com.sirma.itt.javacourse.test.objects.task5.heterogeneousTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.Point;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Rectangle;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Square;
import com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree;

/**
 * JUnit test class for HeterogeneousTree.class.
 * 
 * @author simeon
 */
public class HeterogeneousTreeTest {

	private HeterogeneousTree<Figure> tree;

	/**
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {

		Point p = new Point(10, 10);
		Square sqrt = new Square(p, 10);
		tree = new HeterogeneousTree<Figure>(sqrt, 3);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree#printAllNames()}
	 * .
	 */
	@Test
	public void testPrintAllNames() {
		assertEquals("0 : Square ; \n", tree.printAllNames());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree#addElement(com.sirma.itt.javacourse.objects.task5.heterogeneousTree.NodeElement)}
	 * .
	 */
	@Test
	public void testAddElement() {
		Rectangle rect = new Rectangle(new Point(10, 10), 10, 10);
		assertTrue(tree.addFigureEllemet(rect));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree#addElement(com.sirma.itt.javacourse.objects.task5.heterogeneousTree.NodeElement)}
	 * .
	 */
	@Test
	public void testAddElementTwiceWillRetunFalse() {
		Rectangle rect = new Rectangle(new Point(10, 10), 10, 10);
		tree.addFigureEllemet(rect);
		assertFalse(tree.addFigureEllemet(rect));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree#addElement(com.sirma.itt.javacourse.objects.task5.heterogeneousTree.NodeElement)}
	 * .
	 */
	@Test
	public void testAddingMultipleElementsInTheTree() {
		Rectangle rect = new Rectangle(new Point(10, 10), 10, 10);
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		tree.addFigureEllemet(new Rectangle(new Point(10, 10), 10, 10));
		assertTrue(tree.addFigureEllemet(rect));
	}
}
