package com.sirma.itt.javacourse.objects.task3.supermarket.productObjects;

import java.util.Date;

/**
 * @author simeon
 */
public class AlcoholicBevareges extends NonAlcholicBeverageProducts {

	private float alcoholPercentige;

	/**
	 * Getter method for alcoholPercentige.
	 * 
	 * @return the alcoholPercentige
	 */
	public float getAlcoholPercentige() {
		return alcoholPercentige;
	}

	/**
	 * Setter method for alcoholPercentige.
	 * 
	 * @param alcoholPercentige
	 *            the alcoholPercentige to set
	 */
	public void setAlcoholPercentige(float alcoholPercentige) {
		this.alcoholPercentige = alcoholPercentige;
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
	 * @param alcoholPercentige
	 *            the percent of alcohol in the beverage.
	 */
	public AlcoholicBevareges(String productName, String category, Vendor vendor, String units,
			float quantity, float sellingPrice, Date experathionDate, float bottleCapacity,
			int calories, float alcoholPercentige) {
		super(productName, category, vendor, units, quantity, sellingPrice, experathionDate,
				bottleCapacity, calories);
		this.alcoholPercentige = alcoholPercentige;
	}

}
