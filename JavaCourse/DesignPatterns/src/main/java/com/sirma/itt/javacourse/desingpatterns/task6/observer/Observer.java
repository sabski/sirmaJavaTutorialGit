package com.sirma.itt.javacourse.desingpatterns.task6.observer;

/**
 * Interface that will be used for Observer classes to update the state of the observable item.
 * 
 * @author Simeon Iliev
 */
public interface Observer {

	/**
	 * Updates the current state of the Observable object.
	 * 
	 * @param observable
	 *            the object that has changed state.
	 */
	public void update(Observable observable);

}
