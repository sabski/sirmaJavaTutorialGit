package com.sirma.itt.javacourse.chat.common;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Test;

import com.sirma.itt.javacourse.chat.common.utils.LANGUAGES;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

/**
 * Test class for {@link LanguageController}.
 * 
 * @author siliev
 * 
 */
public class TestLanguageControler {

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.common.utils.LanguageController#setLanguage(java.lang.String)}
	 * .
	 */
	@Test
	public void testSetLanguage() {
		LanguageController.setLanguage(LANGUAGES.EN.toString());
		assertEquals(LANGUAGES.EN.toString(),
				LanguageController.getCurrentLanguage());
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.common.utils.LanguageController#getWord(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetWord() {
		try {
			LanguageController.loadCurrentLanguage();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		assertEquals("Send", LanguageController.getWord("send"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.chat.common.utils.LanguageController#getCurrentLanguage()}
	 * .
	 */
	@Test
	public void testGetCurrentLanguage() {
		assertEquals(LANGUAGES.EN.toString(),
				LanguageController.getCurrentLanguage());
	}

}
