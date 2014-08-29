package com.sirma.itt.javacourse.objects.task4.binaryTree;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Class for running binary tree.
 * 
 * @author simeon
 */
public class TreeRunner {

	/**
	 * @param args
	 *            for main method
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node node = new Node();
		tree.setRootNode(node);
		System.out.println("Insert the number of tree elements");
		int lenght = IOUtils.readInt();
		for (int i = 0; i < lenght; i++) {
			System.out.println("Insert tree element");
			int temp = IOUtils.readInt();
			tree.getRootNode().insertIntoNode(temp);
		}
		tree.printSortedElements();
		System.out.println("Search the tree for ellement");
		tree.searchTree(IOUtils.readInt());
	}

}
