package com.sirma.itt.javacourse.intro.mathUtil;

import java.util.Scanner;

/**
 * @author simeon
 */
public final class MathRun {

	/**
	 * @param args
	 *            to be inserted in runtime
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		MathUtil math = new MathUtil();
		int count = 0;
		int[] numbers = new int[2];
		while (count != 2) {
			String line = scan.next();
			numbers[count] = Integer.parseInt(line);
			count++;
		}
		System.out.println(math.getGreatestCommonDivisor(numbers[0], numbers[1]));
		System.out.println(math.getLeastCommonDenominator(numbers[0], numbers[1]));

		scan.close();
	}

	/**
	 * Private Constructor to satisfy .
	 */
	private MathRun() {

	}
}
