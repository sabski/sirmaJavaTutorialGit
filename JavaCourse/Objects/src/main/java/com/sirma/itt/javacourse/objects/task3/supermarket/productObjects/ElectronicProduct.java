package com.sirma.itt.javacourse.objects.task3.supermarket.productObjects;

/**
 * Class that describes the parameters of a Electronic product.
 * 
 * @author simeon
 */
public class ElectronicProduct extends Product {

	private String grade;
	private float voltage;
	private String shortDescriptiom;
	private int warranty;

	/**
	 * Getter method for grade.
	 * 
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Setter method for grade.
	 * 
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * Getter method for voltage.
	 * 
	 * @return the voltage
	 */
	public float getVoltage() {
		return voltage;
	}

	/**
	 * Setter method for voltage.
	 * 
	 * @param voltage
	 *            the voltage to set
	 */
	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}

	/**
	 * Getter method for shortDescriptiom.
	 * 
	 * @return the shortDescriptiom
	 */
	public String getShortDescriptiom() {
		return shortDescriptiom;
	}

	/**
	 * Setter method for shortDescriptiom.
	 * 
	 * @param shortDescriptiom
	 *            the shortDescriptiom to set
	 */
	public void setShortDescriptiom(String shortDescriptiom) {
		this.shortDescriptiom = shortDescriptiom;
	}

	/**
	 * Getter method for waranty.
	 * 
	 * @return the waranty
	 */
	public int getWaranty() {
		return warranty;
	}

	/**
	 * Setter method for waranty.
	 * 
	 * @param waranty
	 *            the waranty to set
	 */
	public void setWaranty(int waranty) {
		this.warranty = waranty;
	}

	/**
	 * Constructor for Electronic Product.
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
	 * @param grade
	 *            the electricity usage grade of the product.
	 * @param voltage
	 *            the voltage at which the device runs
	 * @param shortDescriptiom
	 *            a short technical description of the product
	 * @param waranty
	 *            the years of warranty for the product.
	 */
	public ElectronicProduct(String productName, String category, Vendor vendor, String units,
			float quantity, float sellingPrice, String grade, float voltage,
			String shortDescriptiom, int waranty) {
		super(productName, category, vendor, units, quantity, sellingPrice);
		this.grade = grade;
		this.voltage = voltage;
		this.shortDescriptiom = shortDescriptiom;
		this.warranty = waranty;
	}

}
