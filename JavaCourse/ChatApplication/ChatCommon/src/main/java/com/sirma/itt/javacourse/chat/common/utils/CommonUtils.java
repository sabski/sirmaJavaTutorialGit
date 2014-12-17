package com.sirma.itt.javacourse.chat.common.utils;

public class CommonUtils {

	public static String[] splitList(String content) {
		String[] users = content.replaceAll("\\[", "").replaceAll("\\]", "")
				.split(", ");
		return users;
	}
}
