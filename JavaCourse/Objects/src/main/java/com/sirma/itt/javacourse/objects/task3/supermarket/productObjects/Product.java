package com.sirma.itt.javacourse.objects.task3.supermarket.productObjects;

/**
 * Base class for product Objects.
 * 
 * @author simeon
 */
public class Product implements ProductInterface {

	private String productName;
	private String category;
	private Vendor vendor;
	private String units;
	private float quantity;
	private float sellingPrice;

	/**
	 * Getter method for productName.
	 * 
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Setter method for productName.
	 * 
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Getter method for category.
	 * 
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Setter method for category.
	 * 
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Getter method for vendor.
	 * 
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}

	/**
	 * Setter method for vendor.
	 * 
	 * @param vendor
	 *            the vendor to set
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	/**
	 * Getter method for units.
	 * 
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * Setter method for units.
	 * 
	 * @param units
	 *            the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}

	/**
	 * Getter method for quantity.
	 * 
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}

	/**
	 * Setter method for quantity.
	 * 
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	/**
	 * Getter method for sellingPrice.
	 * 
	 * @return the sellingPrice
	 */
	public float getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * Setter method for sellingPrice.
	 * 
	 * @param sellingPrice
	 *            the sellingPrice to set
	 */
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * Constructor for product.
	 * 
	 * @param productName
	 *            the name of the product.
	 * @param category
	 *            the category of the product.
	 * @param vendor
	 *            the name of the vendor of the product.
	 * @param units
	 *            the units in which the product is measured.
	 * @param quantity
	 *            the starting quantity of the product.
	 * @param sellingPrice
	 *            the price in which a unit of the given product is sold.
	 */
	public Product(String productName, String category, Vendor vendor, String units,
			float quantity, float sellingPrice) {
		super();
		this.productName = productName;
		this.category = category;
		this.vendor = vendor;
		this.units = units;
		this.quantity = quantity;
		this.sellingPrice = sellingPrice;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void resuply(float quantity) {
		this.quantity += quantity;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reduceQuantaty(float quantity) {
		this.quantity -= quantity;
	}

	@Override
	public float getTotalPrice(float quantity) {
		return quantity * sellingPrice;
	}
}
