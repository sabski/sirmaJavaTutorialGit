package com.sirma.itt.javacourse.chat.client.managers;


/**
 * Class that holds the current client settings.
 * 
 * @author siliev
 * 
 */
public class ClientInfo {

	private static ClientInfo instance;

	private String userName;

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
}
