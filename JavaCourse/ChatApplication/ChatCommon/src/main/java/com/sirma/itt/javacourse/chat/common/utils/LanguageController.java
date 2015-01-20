package com.sirma.itt.javacourse.chat.common.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * This class contains is designed to set and manage the language of the
 * application by getting the resource bundles, and retrieving properties. The
 * default value of the languages is currently set to EN. For now we support
 * only two languages EN and BG.
 * 
 * @author siliev
 * 
 */
public class LanguageController {

	private static final Logger LOGGER = Logger
			.getLogger(LanguageController.class);


	private static String currentLanguage = LANGUAGES.EN.toString();
	private static Locale currentLocale;
	private static ResourceBundle messages;

	/**
	 * Setting the constructor to private to prevent getting instances of this
	 * class.
	 */
	private LanguageController() {

	}

	/**
	 * Sets the current language.
	 * 
	 * @param language
	 *            the languege to be set.
	 */
	public static void setLanguage(String language) {
		currentLanguage = language;
		loadCurrentLanguage();
		LOGGER.info("Current language is " + language);
	}

	/**
	 * Loads the currently set Language.
	 */
	public static void loadCurrentLanguage() {
		currentLocale = new Locale(currentLanguage);
		messages = ResourceBundle.getBundle("locale", currentLocale);
	}

	/**
	 * Retrieves the value of a property by its keyword.
	 * 
	 * @param keyword
	 *            the keyword to search in the property files.
	 * @return the property value of the searched keyword.
	 */
	public static String getWord(String keyword) {
		return messages.getString(keyword);
	}

	/**
	 * Returns the current language value.
	 * 
	 * @return the current language setting
	 */
	public static String getCurrentLanguage() {
		return currentLanguage;
	}

}
