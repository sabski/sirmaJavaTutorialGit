package com.sirma.itt.javacourse.intro.arrayUtil;


/**
 * @author simeon
 */
public final class RunArrayUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayUtil util = new ArrayUtil();
		System.out.println(util.getMinElement(arr));
		System.out.println(util.sum(arr));
		util.print(arr);
	}

	/**
	 * 
	 */
	private RunArrayUtil() {

	}
}
