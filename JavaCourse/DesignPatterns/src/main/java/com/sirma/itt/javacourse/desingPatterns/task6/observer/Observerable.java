package com.sirma.itt.javacourse.desingPatterns.task6.observer;

/**
 * Interface that allow us to attache, detach and notify observers of changes.
 * 
 * @author Simeon Iliev
 */
public interface Observerable {

	/**
	 * Attaches an observer.
	 * 
	 * @param obs
	 *            observer to be attached.
	 */
	public void attachObserver(Observer obs);

	/**
	 * Detaches an observer.
	 * 
	 * @param obs
	 *            observer to be detached.
	 */
	public void dettachObserver(Observer obs);

	/**
	 * Notifies all observers.
	 * 
	 * @param obs
	 *            the observerale that has changed state.
	 */
	public void notifyObservers(Observerable obs);

	/**
	 * Shows how many observers are attached to the current observerable.
	 * 
	 * @return the number of observers.
	 */
	public int getObserverCount();
}
