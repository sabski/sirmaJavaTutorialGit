package com.sirma.itt.javacourse.librariesAndClasspath.task2.pakegeJar;

import com.sirma.itt.javacourse.Utils;
import com.sirma.itt.javacourse.intro.task1.mathUtil.MathRun;
import com.sirma.itt.javacourse.intro.task2.arrayUtil.RunArrayUtil;
import com.sirma.itt.javacourse.intro.task3.median.RunFindArrayMedian;
import com.sirma.itt.javacourse.intro.task4.arraySorting.RunQuickSort;
import com.sirma.itt.javacourse.intro.task5.arrayReverse.RunReverseArray;
import com.sirma.itt.javacourse.intro.task6.stringCalculator.RunStringCalculator;
import com.sirma.itt.javacourse.intro.task7.randomGenerator.RunRandomStringGenerator;
import com.sirma.itt.javacourse.intro.task8.hangman.RunHangman;


/**
 * @author simeon
 */
public class MainMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		String line = "Menu of available operathions: \n 1: Run MathUtil \n 2: Run ArrayUtil \n"
				+ " 3: Find the Median of an array \n 4:Sort an array using QuickSort \n 5: Reverse Array \n "
				+ "6: Calculate the sum of two numbers \n 7: Generate Random Strings \n 8: Play Hangman game \n"
				+ " -1: Exit Program \n";
		do {
			System.out.println(line);
			input = Utils.readLineNumber();
			menuBoard(input);
		} while (input != -1);
	}

	public static void menuBoard(int input) {

		switch (input) {
			case 1:
				MathRun.main(null);
				break;
			case 2:
				RunArrayUtil.main(null);
				break;
			case 3:
				RunFindArrayMedian.main(null);
				break;
			case 4:
				RunQuickSort.main(null);
				break;
			case 5:
				RunReverseArray.main(null);
				break;
			case 6:
				RunStringCalculator.main(null);
				break;
			case 7:
				RunRandomStringGenerator.main(null);
				break;
			case 8:
				RunHangman.main(null);
				break;
			case -1:
				break;
			default:
				System.out.println("Wrong code");
				break;
		}
	}

}
