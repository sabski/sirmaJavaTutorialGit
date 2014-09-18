package com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager;

/**
 * User class that will represent a user that contains some data.
 * 
 * @author Simeon Iliev
 */
public class User {

	private int postalCode = 0;
	private String creditCardNumber = null;
	private double EGN = 0d;
	private String name = null;
	private String address = null;

	/**
	 * Getter method for name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method for name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method for address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter method for address.
	 * 
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter method for postalCode.
	 * 
	 * @return the postalCode
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * Setter method for postalCode.
	 * 
	 * @param postalCode
	 *            the postalCode to set
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Getter method for creditCardNumber.
	 * 
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * Setter method for creditCardNumber.
	 * 
	 * @param creditCardNumber
	 *            the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * Getter method for EGN.
	 * 
	 * @return the EGN
	 */
	public double getEGN() {
		return EGN;
	}

	/**
	 * Setter method for EGN.
	 * 
	 * @param EGN
	 *            the EGN to set
	 */
	public void setEGN(double EGN) {
		this.EGN = EGN;
	}

}
