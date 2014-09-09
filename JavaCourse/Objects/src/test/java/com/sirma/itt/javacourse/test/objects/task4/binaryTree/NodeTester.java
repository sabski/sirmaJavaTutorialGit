package com.sirma.itt.javacourse.test.objects.task4.binaryTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.task4.binaryTree.Node;

public class NodeTester {

	private Node rootNode;

	@Before
	public void setUp() throws Exception {
		rootNode = new Node(15);

	}

	@Test
	public void testInsertIntoNode() {
		rootNode.insertIntoNode(55);
	}

	@Test
	public void testReturnNodeElements() {
		List<Integer> list = rootNode.returnNodeElements();
		assertEquals("[15]", list.toString());
	}

	@Test
	public void testSearchNodes() {
		assertTrue(rootNode.searchNodes(rootNode, 15));
	}

}
