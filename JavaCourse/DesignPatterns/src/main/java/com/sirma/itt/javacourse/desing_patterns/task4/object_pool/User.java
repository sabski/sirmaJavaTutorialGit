package com.sirma.itt.javacourse.desing_patterns.task4.object_pool;

/**
 * Sample user object to be used as test for the object pool pattern;
 * 
 * @author Simeon Iliev
 */
public class User {

	private String userName;
	private String password;
	private String importantConstantData;


	/**
	 * Getter method for userName.
	 * 
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter method for userName.
	 * 
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter method for password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password.
	 * 
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for importantConstantData.
	 * 
	 * @return the importantConstantData
	 */
	public String getImportantConstantData() {
		return importantConstantData;
	}

	/**
	 * Setter method for importantConstantData.
	 * 
	 * @param importantConstantData
	 *            the importantConstantData to set
	 */
	public void setImportantConstantData(String importantConstantData) {
		this.importantConstantData = importantConstantData;
	}

	/**
	 * Resets the current user data.
	 */
	public void reset() {
		userName = null;
		password = null;
		importantConstantData = null;
	}

}
