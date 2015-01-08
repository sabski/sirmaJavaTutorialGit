package com.sirma.itt.javacourse.chat.common.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javax.swing.AbstractButton;

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

	private static Logger log = Logger.getLogger(LanguageController.class);

	public static enum LANGUGES {
		EN("ENGLISH"), BG("bg");

		private final String value;

		private LANGUGES(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	};

	private static String currentLanguage = LANGUGES.EN.toString();
	private static Locale currentLocale;
	private static ResourceBundle messages;
	private static Map<String, AbstractButton> components = new HashMap<String, AbstractButton>();

	/**
	 * Sets the current language.
	 * 
	 * @param language
	 *            the languege to be set.
	 */
	public static void setLanguage(String language) {
		currentLanguage = language;
		loadCurrentLanguage();
		log.info("Current language is " + language);
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
	 * Setting the constructor to private to prevent getting instances of this
	 * class.
	 */
	private LanguageController() {
	}

	/**
	 * 
	 * 
	 * @return the current language setting
	 */
	public static String getCurrentLanguage() {
		return currentLanguage;
	}

	public static void addComponent(String propertyValue,
			AbstractButton component) {
		components.put(propertyValue, component);
	}

	public static void invalidateComponents() {
		for (Entry<String, AbstractButton> entry : components.entrySet()) {
			String value = entry.getKey();
			AbstractButton component = entry.getValue();
			component.setText(getWord(value));
		}
	}
}
