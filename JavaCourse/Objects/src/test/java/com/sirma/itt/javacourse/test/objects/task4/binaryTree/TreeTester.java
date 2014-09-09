package com.sirma.itt.javacourse.test.objects.task4.binaryTree;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.task4.binaryTree.BinaryTree;
import com.sirma.itt.javacourse.objects.task4.binaryTree.Node;

/**
 * Class for testing the binary tree.
 * 
 * @author simeon
 */
public class TreeTester {

	private BinaryTree tree;
	private Node rootNode;
	private ArrayList<Integer> arr = new ArrayList<Integer>();

	/**
	 * Sets up the tree for testing.
	 * 
	 * @throws Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {

		rootNode = new Node(10);
		tree = new BinaryTree();
		tree.setRootNode(rootNode);
		tree.insertIntoTree(7);
		tree.insertIntoTree(5);
		tree.insertIntoTree(4);
		tree.insertIntoTree(6);
		tree.insertIntoTree(12);
		tree.insertIntoTree(11);
		tree.insertIntoTree(18);
		tree.insertIntoTree(15);
		tree.insertIntoTree(20);

		Integer[] temp = { 4, 5, 6, 7, 10, 11, 12, 15, 18, 20 };
		arr.addAll(Arrays.asList(temp));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task4.binaryTree.BinaryTree#printSortedElements()}.
	 */
	@Test
	public void testPrintSortedElements() {
		//assertEquals(arr, tree.printSortedElements());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task4.binaryTree.BinaryTree#insertIntoTree(int)}.
	 */
	@Test
	public void testInsertIntoTree() {
		assertTrue(tree.insertIntoTree(21));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.task4.binaryTree.BinaryTree#searchTree(int)}.
	 */
	@Test
	public void testSearchTree() {
		assertTrue(tree.searchTree(15));
	}

	@Test
	public void testSearchWithSmallNember() {
		assertTrue(!tree.searchTree(-1));
	}
	@Test
	public void testSearchWithBigNumber(){
		assertTrue(!tree.searchTree(999));
	}
	
	
}
