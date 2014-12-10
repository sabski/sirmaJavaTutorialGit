package com.sirma.itt.javacourse;


/**
 * The originator of {@link MessageMemento} objects.
 * 
 * @author Simeon Iliev
 */
public class MessageOriginator {

	private String state;

	/**
	 * Setter method for state.
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Restores the state of the object to a selected state from the memento.
	 * 
	 * @param memento
	 *            the memento we want to restore a state from.
	 * @return the state that has been restored from the memento.
	 */
	public String restoreFromMemento(MessageMemento memento) {
		state = memento.getState();
		return state;
	}

	/**
	 * Creates a new saved state for the object.
	 * 
	 * @return the new saved state.
	 */
	public MessageMemento saveToMemento() {
		return new MessageMemento(state);
	}

}
