package com.sirma.itt.javacourse.intro.task2.arrayUtil;

import java.util.ArrayList;
import java.util.Scanner;

import com.sirma.itt.javacourse.Utils;
import com.sun.corba.se.spi.orbutil.fsm.Input;

/**
 * Class for running the ArrayUtil class.
 * 
 * @author simeon
 */
public class RunArrayUtil {

	/**
	 * Main method for starting the the run arrayUtil class.
	 * 
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr;
		ArrayUtil util = new ArrayUtil();
		ArrayList<Integer> list = new ArrayList<Integer>();

		list = Utils.inputArrayListOfIntegers();

		arr = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}

		System.out.println("The smallest ellement in the array is " + util.getMinElement(arr));
		System.out.println("The sum of the array is " + util.sum(arr));
		System.out.println("The array will be printed in the line bellow. ");
		util.print(arr);
	}

}
