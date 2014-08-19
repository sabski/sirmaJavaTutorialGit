package com.sirma.itt.javacourse.test.objects.task4.binaryTree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.task4.binaryTree.Node;

public class NodeTester {

	private Node rootNode;
	private Node firstNode;
	private Node secondNode;
	
	@Before
	public void setUp() throws Exception {
		rootNode = new Node(15);
		firstNode = new Node(8);
		secondNode = new Node(35);
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
