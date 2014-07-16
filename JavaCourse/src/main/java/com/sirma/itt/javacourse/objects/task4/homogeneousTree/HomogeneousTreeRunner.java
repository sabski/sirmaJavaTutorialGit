package com.sirma.itt.javacourse.objects.task4.homogeneousTree;

import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.Point;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Rectangle;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Square;

/**
 * Class for running HomogeneousTree.
 * 
 * @author simeon
 */
public class HomogeneousTreeRunner {

	/**
	 * @param args
	 *            arrr
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomogeneousTree<Figure> fig = new HomogeneousTree<Figure>();
		Point p = new Point(20, 20);
		Rectangle rect = new Rectangle(p, 0, 0);
		Rectangle rect2 = new Rectangle(p, 0, 0);
		Rectangle rect3 = new Rectangle(p, 0, 0);
		Rectangle rect4 = new Rectangle(p, 0, 0);
		Square sqrt = new Square(p, 15);
		NodeElement<Figure> element = new NodeElement<Figure>(rect);
		fig.setRootEllement(element);
		fig.addFigureEllemet(rect2);
		fig.addFigureEllemet(rect3);
		fig.addFigureEllemet(rect4);
		fig.addFigureEllemet(sqrt);
		fig.printAllNames();
	}

}
