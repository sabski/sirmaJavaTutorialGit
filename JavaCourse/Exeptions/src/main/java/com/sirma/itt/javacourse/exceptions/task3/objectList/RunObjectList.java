package com.sirma.itt.javacourse.exceptions.task3.objectList;

/**
 * @author simeon
 */
public class RunObjectList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectList list = new ObjectList(10);
		// list.removeEllement();
		Integer five = 5;
		list.addElement(1);
		list.addElement(2);
		list.addElement(3);
		list.addElement(4);
		list.addElement(five);
		list.addElement(6);
		list.addElement(7);
		list.printAllElements();
		list.removeElementByObject(5);
		list.printAllElements();
		list.removeElementAtIndex(3);
		list.printAllElements();
		/*
		 * list.addElement(5); list.addElement(5); list.addElement(5); list.addElement(5);
		 * list.addElement(5); list.addElement(5); list.addElement(5); list.addElement(5);
		 * list.addElement(5);
		 */
	}

}
