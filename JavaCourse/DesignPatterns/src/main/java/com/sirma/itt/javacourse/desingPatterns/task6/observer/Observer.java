package com.sirma.itt.javacourse.desingPatterns.task6.observer;

/**
 * 
 * @author Simeon Iliev
 */
public interface Observer {

	/**
	 * Updates the current state of the observerble object.
	 * 
	 * @param obs
	 *            the object that has changed state.
	 */
	public void update(Observerable obs);

}
