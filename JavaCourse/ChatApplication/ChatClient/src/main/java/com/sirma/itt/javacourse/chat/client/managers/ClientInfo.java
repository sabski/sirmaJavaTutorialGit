package com.sirma.itt.javacourse.chat.client.managers;

import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

/**
 * Class that holds the current client settings.
 * 
 * @author siliev
 * 
 */
public class ClientInfo {

	private static ClientInfo instance;

	private String userName;
	private LanguageController controller;

	public static ClientInfo getInstance() {
		if (instance == null) {
			instance = new ClientInfo();
		}
		return instance;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the controller
	 */
	public LanguageController getController() {
		return controller;
	}

	/**
	 * @param contrloer
	 *            the controller to set
	 */
	public void setContrloer(LanguageController contrloer) {
		this.controller = contrloer;
	}
}
