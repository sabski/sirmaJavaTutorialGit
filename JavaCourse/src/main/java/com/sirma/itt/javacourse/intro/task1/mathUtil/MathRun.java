package com.sirma.itt.javacourse.intro.task1.mathUtil;

import java.util.Scanner;

import com.sirma.itt.javacourse.InputUtil;

/**
 * Class for running the MAthUtil class.
 * 
 * @author simeon
 */
public class MathRun {

	/**
	 * @param args
	 *            to be inserted in runtime
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathUtil math = new MathUtil();
		int count = 0;
		int[] numbers = new int[2];
		System.out.println("Input 2 numbers");
		while (count != 2) {
			numbers[count] = InputUtil.readLineNumber();
			count++;
		}
		System.out.println(math.getGreatestCommonDivisor(numbers[0], numbers[1]));
		System.out.println(math.getLeastCommonDenominator(numbers[0], numbers[1]));

	}
}
