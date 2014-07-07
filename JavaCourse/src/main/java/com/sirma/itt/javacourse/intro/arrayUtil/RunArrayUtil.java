package com.sirma.itt.javacourse.intro.arrayUtil;

/**
 * Class for running the ArrayUtil class.
 * 
 * @author simeon
 */
public class RunArrayUtil {

	/**
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayUtil util = new ArrayUtil();
		System.out.println(util.getMinElement(arr));
		System.out.println(util.sum(arr));
		util.print(arr);
	}

}
