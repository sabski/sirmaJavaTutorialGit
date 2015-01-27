package com.sirma.itt.javacourse.chat.common.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
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

	private static final String PROPERTIES = "locale";
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
	 *            the language to be set.
	 */
	public static void setLanguage(String language) {
		currentLanguage = language;
		try {
			loadCurrentLanguage();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		LOGGER.info("Current language is " + language);
	}

	/**
	 * Loads the currently set Language.
	 * 
	 * @throws MalformedURLException
	 */
	public static void loadCurrentLanguage() throws MalformedURLException {
		currentLocale = new Locale(currentLanguage);
		File file = new File("locale.properties");
		URL[] urls = { file.toURI().toURL() };
		ClassLoader loader = new URLClassLoader(urls);
		messages = ResourceBundle.getBundle(PROPERTIES, currentLocale, loader);
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
