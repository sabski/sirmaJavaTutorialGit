package com.sirma.itt.javacourse.test.objects.task5.heterogeneousTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.Point;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Rectangle;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Square;
import com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree;
import com.sirma.itt.javacourse.objects.task5.heterogeneousTree.NodeElement;

/**
 * @author simeon
 */
public class HeterogeneousTreeTest {

	private HeterogeneousTree<Figure> squares;

	/**
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		squares = new HeterogeneousTree<Figure>();
		Point p = new Point(10, 10);
		Square sqrt = new Square(p, 10);
		NodeElement<Figure> root = new NodeElement<Figure>(sqrt);
		squares.setRootEllement(root);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree#printAllNames()}
	 * .
	 */
	@Test
	public void testPrintAllNames() {
		assertEquals("Square", squares.printAllNames());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree#addElement(com.sirma.itt.javacourse.objects.task5.heterogeneousTree.NodeElement)}
	 * .
	 */
	@Test
	public void testAddElement() {
		Rectangle rect = new Rectangle(new Point(10, 10), 10, 10);
		assertTrue(squares.addFigureEllemet(rect));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task5.heterogeneousTree.HeterogeneousTree#addFigureEllemet(com.sirma.itt.javacourse.objects.task2.shapes.Figure)}
	 * .
	 */
	@Test
	public void testAddFigureEllemet() {
		Rectangle rect = new Rectangle(new Point(10, 10), 10, 10);
		NodeElement<Figure> figure = new NodeElement<Figure>(rect);
		assertTrue(squares.addElement(figure));
	}

}
