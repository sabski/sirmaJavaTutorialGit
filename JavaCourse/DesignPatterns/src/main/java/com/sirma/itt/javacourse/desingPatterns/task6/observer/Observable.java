package com.sirma.itt.javacourse.desingPatterns.task6.observer;

/**
 * Interface that allow us to attache, detach and notify observers of changes.
 * 
 * @author Simeon Iliev
 */
public interface Observable {

	/**
	 * Attaches an observer.
	 * 
	 * @param observer
	 *            Observer to be attached.
	 */
	public void attachObserver(Observer observer);

	/**
	 * Detaches an observer.
	 * 
	 * @param observer
	 *            Observer to be detached.
	 */
	public void dettachObserver(Observer observer);

	/**
	 * Notifies all observers.
	 * 
	 * @param observable
	 *            The Observable that has changed state.
	 */
	public void notifyObservers(Observable observable);

	/**
	 * Shows how many observers are attached to the current Observable.
	 * 
	 * @return the number of observers.
	 */
	public int getObserverCount();
}
