package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sirma.itt.javacourse.InputUtils;

/**
 * Runner class for sorting Annotation task.
 * 
 * @author simeon
 */
public class RunSortingAnnotaions {

	/**
	 * Main method for the app.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		list.add(new ChildAClass(3, "Hello"));
		list.add(new ChildAClass(1, "Motto"));
		list.add(new ChildAClass(2, "Linux"));
		list.add(new ChildBClass(3, 2.14f, "e"));
		list.add(new ChildBClass(4, 2.14f, "h"));
		list.add(new ChildBClass(5, 2.14f, "mouse"));
		list.add(new ChildBClass(6, 2.14f, "gambit"));
		list.add(new ChildCClass(7, 1.2d, "King to e4"));
		list.add(new ChildCClass(8, 1.2d, "check"));
		list.add(new ChildCClass(9, 1.2d, "Ruler"));
		list.add(new ChildCClass(10, 1.2d, "Eraser"));
		list.add(new ParrentClass(11));
		list.add(new ParrentClass(12));
		list.add(new ParrentClass(13));
		InputUtils.printConsoleMessage("Before Sorting");
		InputUtils.printConsoleMessage(list.toString());
		InputUtils.printConsoleMessage("After Sorting");
		Collections.sort(list, new ComparatorAnnotaion());
		InputUtils.printConsoleMessage(list.toString());
	}

}
