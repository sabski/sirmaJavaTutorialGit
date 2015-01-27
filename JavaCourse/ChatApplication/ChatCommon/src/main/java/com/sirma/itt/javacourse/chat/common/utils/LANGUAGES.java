package com.sirma.itt.javacourse.chat.common.utils;

public enum LANGUAGES {
	EN("ENGLISH"), BG("BG");

	private final String value;

	private LANGUAGES(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
};