package com.sirma.itt.javacourse.objects.task3.supermarket.humanObjects;

/**
 * Base class for representing human being in a supermarket.
 * 
 * @author simeon
 */
public class Human {

	private String name;
	private String egn;
	private String address;
	private boolean gender;

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
	 * Getter method for eGN.
	 * 
	 * @return the eGN
	 */
	public String getEGN() {
		return egn;
	}

	/**
	 * Setter method for eGN.
	 * 
	 * @param eGN
	 *            the eGN to set
	 */
	public void setEGN(String eGN) {
		egn = eGN;
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
	 * Getter method for gender.
	 * 
	 * @return the gender
	 */
	public boolean isGender() {
		return gender;
	}

	/**
	 * Setter method for gender.
	 * 
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}

	/**
	 * Base human constructor.
	 * 
	 * @param name
	 *            of the human
	 * @param egn
	 *            personal number
	 * @param address
	 *            the address of the human
	 * @param gender
	 *            the gender of the human
	 */
	public Human(String name, String egn, String address, boolean gender) {
		super();
		this.name = name;
		this.egn = egn;
		this.address = address;
		this.gender = gender;
	}

}
