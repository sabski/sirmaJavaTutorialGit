package com.sirma.itt.javacourse.objects.task5.heterogeneousTree;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.objects.task2.shapes.Figure;
import com.sirma.itt.javacourse.objects.task4.binaryTree.Node;

/**
 * This class represent a generic type collection that extend Figure.
 * 
 * @param <T>
 *            generic parameter
 * @author simeon
 */
public class HeterogeneousTree<T extends Figure> {

	private NodeElement<T> rootEllement;
	private int childCount;

	/**
	 * Getter method for rootEllement.
	 * 
	 * @return the rootEllement
	 */
	public NodeElement<T> getRootEllement() {
		return rootEllement;
	}

	/**
	 * Setter method for rootEllement.
	 * 
	 * @param rootEllement
	 *            the rootEllement to set
	 */
	public void setRootEllement(NodeElement<T> rootEllement) {
		this.rootEllement = rootEllement;
	}

	/**
	 * Prints all the element names.
	 * 
	 * @return The name of the objects in the tree.
	 */
	public String printAllNames() {
		return printElementNode(rootEllement);
	}

	/**
	 * Prints in the console the elements name and that of its children.
	 * 
	 * @param node
	 *            the node element to be printed
	 * @return The names of the objects.
	 */
	private String printElementNode(NodeElement<T> node) {
		StringBuilder builder = new StringBuilder();

		List<List<NodeElement<T>>> levels = levelBuilder(0, new ArrayList<List<NodeElement<T>>>(),
				rootEllement);
		for (List<NodeElement<T>> level : levels) {
			for (NodeElement<T> element : level) {
				builder.append(levels.indexOf(level) + " : " + element.getObject().getName()
						+ " ; \n");
			}
		}

		return builder.toString();
	}

	/**
	 * Add directly a figure element to the tree.
	 * 
	 * @param f
	 *            the Figure we are adding
	 * @return True if element was inserted.
	 */
	public boolean addFigureEllemet(Figure f) {
		NodeElement<T> node = new NodeElement<T>(f);
		return insertNode(node);
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
	private boolean insertNode(NodeElement<T> nodeTobeInserted) {
		List<List<NodeElement<T>>> levels = levelBuilder(0, new ArrayList<List<NodeElement<T>>>(),
				rootEllement);
		// Loops the level Objects then loop the objects in the current level to see if any one of
		// them contains the same valued object in its content node.
		for (List<NodeElement<T>> level : levels) {
			for (NodeElement<T> node : level) {
				if (node.getObject().equals(nodeTobeInserted.getObject())) {
					return false;
				}
			}
		}

		// We select the last level that is in the level list and if the list has achieved maximum
		// children for that level we add the new element to the first element of the last level.
		List<NodeElement<T>> level = levels.get(levels.size() - 1);
		IOUtils.printConsoleMessage("Last level size " + level.size());

		if (levels.size() == 1) {
			rootEllement.getChildren().add(nodeTobeInserted);
			IOUtils.printConsoleMessage("Adding to root element");
			return true;
		} else if (childCount > rootEllement.getChildren().size()) {
			rootEllement.getChildren().add(nodeTobeInserted);
			IOUtils.printConsoleMessage("Adding to root element");
			return true;
		} else if (level.size() == (levels.get(levels.indexOf(level) - 1).size() * childCount)) {
			IOUtils.printConsoleMessage("row is full : "
					+ (childCount * levels.get(levels.indexOf(level) - 1).size()));
			NodeElement<T> node = level.get(0);
			node.getChildren().add(nodeTobeInserted);
			return true;
		} else {
			int index = (level.size() / childCount);
			IOUtils.printConsoleMessage("index : " + index + " level size " + level.size());
			levels.get(levels.indexOf(level) - 1).get(index).getChildren().add(nodeTobeInserted);
			return true;
		}
	}

	/**
	 * Creates the level schema of the tree.
	 * 
	 * @param level
	 *            the current level we are building.
	 * @param list
	 *            the fill list of levels and elements in a level
	 * @param nodeElement
	 *            the current node element we are placing in the level.
	 * @return the list of elements in the tree.
	 */
	private List<List<NodeElement<T>>> levelBuilder(int level, List<List<NodeElement<T>>> list,
			NodeElement<T> nodeElement) {
		// If the level we are is not present we create it.
		if (level > list.size()) {
			list.add(new ArrayList<NodeElement<T>>());
			list.get(level).add(nodeElement);
		} else if (list.size() == 0) {
			list.add(new ArrayList<NodeElement<T>>());
			list.get(level).add(nodeElement);
		} else {
			if (level == list.size()) {
				list.add(new ArrayList<NodeElement<T>>());
			}
			list.get(level).add(nodeElement);
		}

		// Add the children of the node to the next level.
		for (NodeElement<T> node : nodeElement.getChildren()) {
			list = levelBuilder((level + 1), list, node);
		}
		return list;
	}

	/**
	 * Getter method for childCount.
	 * 
	 * @return the childCount
	 */
	public int getChildCount() {
		return childCount;
	}

	/**
	 * Setter method for childCount.
	 * 
	 * @param childCount
	 *            the childCount to set
	 */
	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}
}
