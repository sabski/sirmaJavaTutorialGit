package com.sirma.itt.javacourse.intro.task2.arrayUtil;

import java.util.ArrayList;
import java.util.Scanner;

import com.sirma.itt.javacourse.InputUtil;
import com.sun.corba.se.spi.orbutil.fsm.Input;

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
		System.out.println("Plese input numbers for the array");
		numbersCount = InputUtil.readLineNumber();
		for (int i = 0; i < numbersCount; i++) {
			list.add(InputUtil.readLineNumber());
		}
		arr = new int[numbersCount];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		System.out.println(util.getMinElement(arr));
		System.out.println(util.sum(arr));
		util.print(arr);
	}

}
