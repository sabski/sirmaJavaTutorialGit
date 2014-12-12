/**
 * 
 */
package com.sirma.itt.javacourse.chat.common;

/**
 * An message interpreter interface.
 * 
 * @author siliev
 * 
 */
public interface MessageInterpretor {

	/**
	 * 
	 * @param message
	 * @param user
	 */
	public void interpretMessage(Message message, ChatUser user);

	public Message generateMessage(String type, long id, String content,
			String author);
}
