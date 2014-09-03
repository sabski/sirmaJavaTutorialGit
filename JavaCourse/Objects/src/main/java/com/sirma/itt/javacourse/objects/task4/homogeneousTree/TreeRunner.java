package com.sirma.itt.javacourse.objects.task4.homogeneousTree;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running homogeneous tree example.
 * 
 * @author simeon
 */
public class TreeRunner {

	/**
	 * Main method for Running HomogeneousTree code.
	 * 
	 * @param args
	 *            main method arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>();
		TreeElement<Integer> rootEllemtnt = new TreeElement<Integer>();
		rootEllemtnt.setElement(15);
		tree.setRootElement(rootEllemtnt);

		tree.addElement(5);
		tree.addElement(8);
		tree.addElement(9);
		tree.addElement(15);
		tree.addElement(52);
		tree.addElement(55);
		tree.addElement(57);
		tree.addElement(35);
		tree.addElement(45);
		tree.addElement(27);
		tree.addElement(38);
		tree.addElement(9);

		IOUtils.printConsoleMessage(tree.testPrintTreeStructure());
	}

}
