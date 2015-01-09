package com.sirma.itt.javacourse.chat.common.utils;

/**
 * Common utilities for performing general tasks.
 * 
 * @author siliev
 * 
 */
public class CommonUtils {

	/**
	 * Splits a string so that it may represented as single values.
	 * 
	 * @param content
	 *            the content we want to split.
	 * @return the values that were spliced.
	 */
	public static String[] splitList(String content) {
		String[] users = content.replaceAll("\\[", "").replaceAll("\\]", "")
				.split(", ");
		return users;
	}
}
