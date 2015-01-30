package com.sirma.itt.javacourse.chat.client.managers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.chat.client.ui.listeners.LanguageListener;
import com.sirma.itt.javacourse.chat.common.utils.LANGUAGES;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

public class TestLanguageListener {

	private LanguageListener listener;

	@Before
	public void setUp() throws Exception {
		listener = new LanguageListener();
	}

	@Test
	public void testActionPerformedEN() {
		LanguageController.setLanguage(LANGUAGES.BG.toString());
		listener.actionPerformed(null);
		assertEquals(LANGUAGES.EN.toString(),
				LanguageController.getCurrentLanguage());
	}

	@Test
	public void testActionPerformedBG() {
		LanguageController.setLanguage(LANGUAGES.EN.toString());
		listener.actionPerformed(null);
		assertEquals(LANGUAGES.BG.toString(),
				LanguageController.getCurrentLanguage());
	}
}
