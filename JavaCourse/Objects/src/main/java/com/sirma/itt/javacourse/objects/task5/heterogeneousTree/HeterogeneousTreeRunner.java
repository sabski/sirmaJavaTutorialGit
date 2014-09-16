package com.sirma.itt.javacourse.objects.task5.heterogeneousTree;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task2.shapes.Point;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Parallelogram;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Rectangle;
import com.sirma.itt.javacourse.objects.task2.shapes.rectangularShapes.Square;

/**
 * Class for running HomogeneousTree.
 * 
 * @author simeon
 */
public class HeterogeneousTreeRunner {

	/**
	 * @param args
	 *            arrr
	 */
	public static void main(String[] args) {
		HeterogeneousTree<Figure> fig;
		Point p = new Point(20, 20);
		Rectangle rect = new Rectangle(p, 0, 0);
		Rectangle rect2 = new Rectangle(p, 0, 0);
		Rectangle rect3 = new Rectangle(p, 0, 0);
		Rectangle rect4 = new Rectangle(p, 0, 0);
		Square sqrt = new Square(p, 15);
		fig = new HeterogeneousTree<Figure>(sqrt, 3);
		fig.addFigureEllemet(rect2);
		fig.addFigureEllemet(rect3);
		fig.addFigureEllemet(rect4);
		fig.addFigureEllemet(sqrt);
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Parallelogram(p, p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Parallelogram(p, p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Parallelogram(p, p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Parallelogram(p, p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Parallelogram(p, p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Parallelogram(p, p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Rectangle(p, 0, 0));
		fig.addFigureEllemet(new Parallelogram(p, p, 0, 0));

		IOUtils.printConsoleMessage("Ellement in the tree : \n" + fig.printAllNames());
	}

}
