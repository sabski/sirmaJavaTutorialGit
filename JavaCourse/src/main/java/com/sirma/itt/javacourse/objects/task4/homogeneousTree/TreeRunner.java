package com.sirma.itt.javacourse.objects.task4.homogeneousTree;

/**
 * Class for running homogeneous tree example.
 * 
 * @author simeon
 */
public class TreeRunner {

	/**
	 * @param args
	 *            main method arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomogeneousTree<Integer> tree = new HomogeneousTree<Integer>();
		TreeElement<Integer> rootEllemtnt = new TreeElement<Integer>();
		rootEllemtnt.setElement(15);
		tree.setRootElement(rootEllemtnt);

		tree.addEllemet(5);
		tree.addEllemet(8);
		tree.addEllemet(9);
		tree.addEllemet(15);
		tree.addEllemet(52);
		tree.addEllemet(55);
		tree.addEllemet(35);
		tree.addEllemet(45);
		tree.addEllemet(27);
		tree.addEllemet(38);
		tree.addEllemet(9);

		tree.printAllValues();
	}

}
