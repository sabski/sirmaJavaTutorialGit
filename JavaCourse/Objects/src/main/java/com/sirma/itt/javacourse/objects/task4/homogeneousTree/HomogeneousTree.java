package com.sirma.itt.javacourse.objects.task4.homogeneousTree;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a generic type collection.
 * 
 * @param <T>
 *            generic parameter
 * @author simeon
 */
public class HomogeneousTree<T> {

	private TreeElement<T> rootElement;

	/**
	 * Getter method for rootElement.
	 * 
	 * @return the rootElement
	 */
	public TreeElement<T> getRootElement() {
		return rootElement;
	}

	/**
	 * Setter method for rootElement.
	 * 
	 * @param rootElement
	 *            the rootElement to set
	 */
	public void setRootElement(TreeElement<T> rootElement) {
		this.rootElement = rootElement;
	}

	/**
	 * Prints all the element names.
	 * 
	 * @return printed values.
	 */
	public String printAllValues() {
		return printElementNode(rootElement);
	}

	public String testPrintTreeStructure() {
		List<List<String>> treeStructyre = levelBulder(0, new ArrayList<List<String>>(),
				rootElement);
		StringBuilder stringBuilder = new StringBuilder();
		for (List<String> level : treeStructyre) {
			// Calculate the space count (tabCount) and insert them before the
			// current level value.
			int tabCount = treeStructyre.size() - treeStructyre.indexOf(level) - 1;
			for (int i = 0; i < tabCount; i++) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(level.toString());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	/**
	 * Prints in the console the elements name and that of its children.
	 * 
	 * @param node
	 *            the node element to be printed
	 * @return printed values
	 */
	private String printElementNode(TreeElement<T> node) {
		StringBuilder build = new StringBuilder();
		if (node.getLeft() != null) {
			build.append(printElementNode(node.getLeft()) + "\n");
		}
		build.append(node.getElement().toString() + "\n");
		if (node.getRight() != null) {
			build.append(printElementNode(node.getRight()) + " \n");
		}
		return build.toString();
	}

	/**
	 * Creates a tree level structure.
	 * 
	 * @param level
	 *            the current level we are building.
	 * @param treeList
	 *            The list that contains the information about the tree levels.
	 * @param element
	 *            the current element we are searching for information.
	 * @return the List of information we have created.s
	 */
	private List<List<String>> levelBulder(int level, List<List<String>> treeList,
			TreeElement<T> element) {
		List<String> currentLevel = getLevel(level, treeList);
		currentLevel.add(element.getElement().toString());
		if (element.getLeft() != null) {
			// Send the left element to be recursively processed.
			levelBulder(level + 1, treeList, element.getLeft());
		} else {
			// Generates null values for end tree elements for better visualization.
			levelGenerator(level + 1, treeList);
		}
		if (element.getRight() != null) {
			// Send the right element to be recursively processed.
			levelBulder(level + 1, treeList, element.getRight());
		} else {
			// Generates null values for end tree elements for better visualization.
			levelGenerator(level + 1, treeList);
		}
		return treeList;
	}

	/**
	 * Generates null levels.
	 * 
	 * @param level
	 *            the current we are at.
	 * @param treeList
	 *            the list that contains all the tree information.
	 */
	private void levelGenerator(int level, List<List<String>> treeList) {
		List<String> tempLVL = getLevel(level, treeList);
		tempLVL.add("null");
	}

	/**
	 * Gets level values for the tree structure. If the is no level created it creates a new one.
	 * 
	 * @param level
	 *            the level we want to get.
	 * @param treeList
	 *            the list of all level elements currently available.
	 * @return the current level instance;
	 */
	private List<String> getLevel(int level, List<List<String>> treeList) {
		List<String> tempLVL;
		if (level > (treeList.size() - 1)) {
			tempLVL = new ArrayList<String>();
			treeList.add(tempLVL);
		} else {
			tempLVL = treeList.get(level);
		}
		return tempLVL;
	}

	/**
	 * Add directly a T element to the tree.
	 * 
	 * @param element
	 *            add element to the tree
	 * @return true if the T element was inserted
	 */
	public void addElement(T element) {
		TreeElement<T> node = new TreeElement<T>();
		node.setElement(element);
		insertNode(rootElement, node);
	}

	/**
	 * Checks if a node should be inserted in the tree.
	 * 
	 * @param treeNode
	 *            an existing node from the tree.
	 * @param nodeTobeInserted
	 *            the node we want to insert.
	 * @return true if we inserted into the tree.
	 */
	private void insertNode(TreeElement<T> treeNode, TreeElement<T> nodeTobeInserted) {
		// Uses the equals method of the T Object to compare the values of the nodes.
		if (treeNode.getElement().equals(nodeTobeInserted.getElement())) {
			return;
		}
		// Checks the hash code of the T Object value and compares it to the hash code value of the
		// nodeTobeInserted element.
		if (treeNode.getElement().hashCode() > nodeTobeInserted.getElement().hashCode()) {
			// If the current tree element has a smaller hash code value then the value we want to
			// insert the element is moved to the left side of the tree.
			if (treeNode.getLeft() != null) {
				insertNode(treeNode.getLeft(), nodeTobeInserted);
			} else {
				treeNode.setLeft(nodeTobeInserted);
			}
		} else {
			if (treeNode.getRight() != null) {
				insertNode(treeNode.getRight(), nodeTobeInserted);
			} else {
				treeNode.setRight(nodeTobeInserted);
			}
		}
	}

	/**
	 * Retries all the element in the tree as a list.
	 * 
	 * @return a list of elements that are in the tree.
	 */
	public List<T> getElementList() {
		return elementExtractor(new ArrayList<T>(), rootElement);
	}

	/**
	 * Extracts the elements of the tree.
	 * 
	 * @param list
	 *            the list that contains all the elements.
	 * @param element
	 *            the current element we are searching.
	 * @return the list of elements.
	 */
	private List<T> elementExtractor(List<T> list, TreeElement<T> element) {
		list.add(element.getElement());
		if (element.getLeft() != null) {
			elementExtractor(list, element.getLeft());
		}
		if (element.getRight() != null) {
			elementExtractor(list, element.getRight());
		}

		return list;
	}
}
