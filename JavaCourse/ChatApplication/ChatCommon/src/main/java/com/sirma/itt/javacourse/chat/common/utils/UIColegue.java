package com.sirma.itt.javacourse.chat.common.utils;

/**
 * 
 * 
 * @author siliev
 * 
 */
public interface UIColegue {

	/**
	 * Sends the UI event that is of interest to the mediator.
	 */
	public void sendUIEvent();

	/**
	 * The current component responds to a mediator Event.
	 */
	public void respondToEvent();

	/**
	 * Register the component to the mediator.
	 */
	public void registerComponent();

}
