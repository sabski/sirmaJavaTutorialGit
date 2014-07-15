package com.sirma.itt.javacourse.objects.task3.supermarket.productObjects;

import java.util.Date;

/**
 * Base class for beverages.
 * 
 * @author simeon
 */
public class BeveragesProducts extends FoodProducts {

	private float bottleCapacity;

	/**
	 * Getter method for bottleCapacity.
	 * 
	 * @return the bottleCapacity
	 */
	public float getBottleCapacity() {
		return bottleCapacity;
	}

	/**
	 * Setter method for bottleCapacity.
	 * 
	 * @param bottleCapacity
	 *            the bottleCapacity to set
	 */
	public void setBottleCapacity(float bottleCapacity) {
		this.bottleCapacity = bottleCapacity;
	}

	/**
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
	 * @param bottleCapacity
	 *            the capacity of the container the beverage is in.
	 */
	public BeveragesProducts(String productName, String category, Vendor vendor, String units,
			float quantity, float sellingPrice, Date experathionDate, float bottleCapacity) {
		super(productName, category, vendor, units, quantity, sellingPrice, experathionDate);
		this.bottleCapacity = bottleCapacity;
	}
}
