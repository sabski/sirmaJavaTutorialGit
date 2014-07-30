package com.sirma.itt.javacourse.objects.task3.supermarket.productObjects;

import com.sirma.itt.javacourse.objects.task3.supermarket.humanObjects.Human;

/**
 * Class that describes the vendor of a given product.
 * 
 * @author simeon
 */
public class Vendor extends Human {

	private String vendorName;
	private String iban;

	/**
	 * Getter method for vendorName.
	 * 
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * Setter method for vendorName.
	 * 
	 * @param vendorName
	 *            the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * Getter method for iban.
	 * 
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * Setter method for iban.
	 * 
	 * @param iban
	 *            the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * Constructor for a vendor.
	 * 
	 * @param name
	 *            the personal name of the vendor
	 * @param egn
	 *            the EGN of the vendor
	 * @param gender
	 *            the gender of the vendor.
	 * @param vendorName
	 *            the name of the vendor.
	 * @param address
	 *            the address that the vendor is located.
	 * @param iban
	 *            the IBAN of the vendor
	 */
	public Vendor(String name, String egn, String address, boolean gender, String vendorName,
			String iban) {
		super(name, egn, address, gender);
		this.vendorName = vendorName;
		this.iban = iban;
	}
}
