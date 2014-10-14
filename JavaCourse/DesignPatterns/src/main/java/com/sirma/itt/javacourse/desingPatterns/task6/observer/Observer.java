package com.sirma.itt.javacourse.desingPatterns.task6.observer;

/**
 * 
 * @author Simeon Iliev
 */
public interface Observer {

	/**
	 * Updates the current state of the Observable object.
	 * 
	 * @param obs
	 *            the object that has changed state.
	 */
	public void update(Observable obs);

}
