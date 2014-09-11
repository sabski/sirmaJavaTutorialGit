package com.sirma.itt.javacourse.desingPatterns.task6.observer;


/**
 * Interface for observing stock quantities.
 * 
 * @author Simeon Iliev
 */
public interface StockObserver {

	/**
	 * Updates the state of the observed object.
	 * 
	 * @param observable
	 *            the object that is to be updated.
	 */
	public void deliveryUpdate(Item observable);

	/**
	 * Updates the state of the observed object.
	 * 
	 * @param observable
	 *            the object that is to be updated.
	 */
	public void purcheaseUpdate(Item observable);
}
