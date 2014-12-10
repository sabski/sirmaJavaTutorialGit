package com.sirma.itt.javacourse;

/**
 * This class is used to store states of a String object.
 * 
 * @author Simeon Iliev
 */
public class MessageMemento {

	private final String state;

	/**
	 * Getter method for state.
	 * 
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Creates a new Memento object that can restore an object to its previous state.
	 * 
	 * @param state
	 *            the state of the object we want to be saved
	 */
	public MessageMemento(String state) {
		this.state = state;
	}

}
