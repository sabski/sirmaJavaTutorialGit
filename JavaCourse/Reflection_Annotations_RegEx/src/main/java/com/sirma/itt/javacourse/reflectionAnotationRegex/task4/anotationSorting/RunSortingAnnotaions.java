package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;

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
		// TODO Auto-generated method stub
		List<ParrentClass> list = new ArrayList<ParrentClass>();
		list.add(new ChildAClass());
		list.add(new ChildAClass());
		list.add(new ChildAClass());
		list.add(new ChildBClass());
		list.add(new ChildBClass());
		list.add(new ChildBClass());
		list.add(new ChildBClass());
		list.add(new ChildCClass());
		list.add(new ChildCClass());
		list.add(new ChildCClass());
		list.add(new ChildCClass());
		list.add(new ParrentClass());
		list.add(new ParrentClass());
		list.add(new ParrentClass());
		ClassSorter sort = new ClassSorter();
		IOUtils.printConsoleMessage("Before Sorting");
		IOUtils.printConsoleMessage(list.toString());
		IOUtils.printConsoleMessage("After Sorting");
		IOUtils.printConsoleMessage(sort.sort(list, new ComparatorAnnotaion()).toString());
	}

}
