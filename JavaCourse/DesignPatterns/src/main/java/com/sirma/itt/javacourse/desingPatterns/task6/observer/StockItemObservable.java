package com.sirma.itt.javacourse.desingPatterns.task6.observer;


/**
 * Observable item interface that can have different States.
 * 
 * @author Simeon Iliev
 */
public abstract class StockItemObservable {

	/**
	 * Attaches an observer to the current object.
	 * 
	 * @param observer
	 *            the observer that is to be attached to the object.
	 */
	public abstract void attachObserver(StockObserver observer);

	/**
	 * Detaches an observer from the current object.
	 * 
	 * @param observer
	 *            the observer that is to be removed.
	 */
	public abstract void detachObserver(StockObserver observer);

}
