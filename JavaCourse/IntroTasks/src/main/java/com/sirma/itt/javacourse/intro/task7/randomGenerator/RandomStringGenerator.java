package com.sirma.itt.javacourse.intro.task7.randomGenerator;

import com.sirma.itt.javacourse.MathUtil;

/**
 * Generates random String with given length using characters from a-z , A-Z and 0-9.
 * 
 * @author simeon
 */
public class RandomStringGenerator {

	/**
	 * Generates random String.
	 * 
	 * @param length
	 *            the length of the String that is to be generated
	 * @return the generated random String
	 */
	public String generateRandomString(int length) {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int key = MathUtil.generateRandomNumberWithRange(1, 3);
			int value;
			switch (key) {
				case 1:
					value = MathUtil.generateRandomNumberWithRange(48, 57);
					builder.append(getCharecterFromInt(value));
					break;
				case 2:
					value = MathUtil.generateRandomNumberWithRange(97, 122);
					builder.append(getCharecterFromInt(value));
					break;
				case 3:
					value = MathUtil.generateRandomNumberWithRange(65, 90);
					builder.append(getCharecterFromInt(value));
					break;
				default:
					break;
			}
		}
		return builder.toString();
	}

	/**
	 * Converts the int to char value.
	 * 
	 * @param charecterAscii
	 *            int value to converted into ascii char
	 * @return the converted ascii char
	 */
	private char getCharecterFromInt(int charecterAscii) {
		return (char) charecterAscii;
	}
}
