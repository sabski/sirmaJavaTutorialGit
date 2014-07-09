package com.sirma.itt.javacourse.intro.arrayUtil;

import java.util.ArrayList;
import java.util.Scanner;

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
		int[] arr;
		ArrayUtil util = new ArrayUtil();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int numbersCount = 0;
		Scanner scaner = new Scanner(System.in);
		System.out.println("Plese input numbers for the array");
		numbersCount = scaner.nextInt();
		for (int i = 0; i < numbersCount; i++) {
			list.add(scaner.nextInt());
		}
		scaner.close();
		arr = new int[numbersCount];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		System.out.println(util.getMinElement(arr));
		System.out.println(util.sum(arr));
		util.print(arr);
	}

}
