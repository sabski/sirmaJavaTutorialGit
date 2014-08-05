package com.sirma.itt.javacourse.reflectionAnotationRegex.task4.anotationSorting;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.Utils;

/**
 * @author simeon
 */
public class RunSortingAnnotaions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ParentClass> list = new ArrayList<ParentClass>();
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
		list.add(new ParentClass());
		list.add(new ParentClass());
		list.add(new ParentClass());
		ClassSorter sort = new ClassSorter();
		Utils.printConsoleMessage("Before Sorting");
		Utils.printConsoleMessage(list.toString());
		Utils.printConsoleMessage("After Sorting");
		Utils.printConsoleMessage(sort.sort(list).toString());
	}

}
