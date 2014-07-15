package com.sirma.itt.javacourse.objects.task3.supermarket.productObjects;

import java.util.Date;

/**
 * @author simeon
 */
public class NonAlcholicBeverageProducts extends BeveragesProducts {

	private int calories;

	/**
	 * Getter method for calories.
	 * 
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}

	/**
	 * Setter method for calories.
	 * 
	 * @param calories
	 *            the calories to set
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}

	/**
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
	 * @param calories
	 *            the calories is in the beverage.
	 */
	public NonAlcholicBeverageProducts(String productName, String category, Vendor vendor,
			String units, float quantity, float sellingPrice, Date experathionDate,
			float bottleCapacity, int calories) {
		super(productName, category, vendor, units, quantity, sellingPrice, experathionDate,
				bottleCapacity);
		this.calories = calories;
	}

}
