package com.sirma.itt.javacourse.objects.task3.supermarket.productObjects;

/**
 * Base interface for standard product actions.
 * 
 * @author simeon
 */
public interface ProductInterface {

	/**
	 * Orders the product again. With the given quantity.
	 * 
	 * @param quantity
	 *            the quantity to be order of the same product.
	 */
	void resuply(float quantity);

	/**
	 * Reduces the quantity of the product with a specific value.
	 * 
	 * @param quantity
	 *            the quantity that was sold and will be reduced from the current quantity.
	 */
	void reduceQuantaty(float quantity);

	/**
	 * Calculates the total sum of a of a purchase from a given total.
	 * 
	 * @param quantity
	 *            the quantity the client wants to purchase.
	 * @return the total sum of the item purchase.
	 */
	float getTotalPrice(float quantity);
}
