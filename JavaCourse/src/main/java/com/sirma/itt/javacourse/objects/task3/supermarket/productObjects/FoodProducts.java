package com.sirma.itt.javacourse.objects.task3.supermarket.productObjects;

import java.util.Date;

/**
 * Class for describing foodProducts.
 * 
 * @author simeon
 */
public class FoodProducts extends Product {

	private Date experathionDate;

	/**
	 * Getter method for experathionDate.
	 * 
	 * @return the experathionDate
	 */
	public Date getExperathionDate() {
		return experathionDate;
	}

	/**
	 * Setter method for experathionDate.
	 * 
	 * @param experathionDate
	 *            the experathionDate to set
	 */
	public void setExperathionDate(Date experathionDate) {
		this.experathionDate = experathionDate;
	}

	/**
	 * Constructor for a standard food product.
	 * 
	 * @param productName
	 *            the name of the product.
	 * @param category
	 *            the category of the product.
	 * @param vendor
	 *            the vendor of the product.
	 * @param units
	 *            the units in which the product is measured example (units, kilogram, grams)
	 * @param quantity
	 *            the quantity of the product.
	 * @param sellingPrice
	 *            the selling price per unit.
	 * @param experathionDate
	 *            the date that the product expires.
	 */
	public FoodProducts(String productName, String category, Vendor vendor, String units,
			float quantity, float sellingPrice, Date experathionDate) {
		super(productName, category, vendor, units, quantity, sellingPrice);
		this.experathionDate = experathionDate;
	}

}