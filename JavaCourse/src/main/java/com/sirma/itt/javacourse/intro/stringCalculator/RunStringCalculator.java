package com.sirma.itt.javacourse.intro.stringCalculator;

import java.util.Scanner;

/**
 * Class for running the String calculator.
 * 
 * @author simeon
 */
public class RunStringCalculator {

	/**
	 * @param args
	 *            for the main method.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCalculator calculator = new StringCalculator();
		String firstBigNumber = null;
		String secondBigNumber = null;
		Scanner scaner = new Scanner(System.in);
		System.out.println("Plese input numbers");
		firstBigNumber = scaner.nextLine();
		secondBigNumber = scaner.nextLine();
		scaner.close();
		System.out.println(calculator.sumStrings(firstBigNumber, secondBigNumber));

	}
}
