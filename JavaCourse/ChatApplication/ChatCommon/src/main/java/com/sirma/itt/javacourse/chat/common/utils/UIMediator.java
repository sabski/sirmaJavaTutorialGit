/**
 * 
 */
package com.sirma.itt.javacourse.chat.common.utils;

/**
 * This interface is for a UI mediator to be used to notify different UI
 * components of events that are relevant to them.
 * 
 * @author siliev
 * 
 */
public interface UIMediator {

	public void processUIEvent();

	public void sendUIEvent();
	
}
