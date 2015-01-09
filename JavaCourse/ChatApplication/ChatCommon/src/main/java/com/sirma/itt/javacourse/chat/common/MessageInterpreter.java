/**
 * 
 */
package com.sirma.itt.javacourse.chat.common;

import com.sirma.itt.javacourse.chat.common.Message.TYPE;

/**
 * An message interpreter interface.
 * 
 * @author siliev
 * 
 */
public interface MessageInterpreter {

	public Message generateMessage(TYPE type, long id, String content,
			String author);

	/**
	 * Interprets a message by using the {@link TYPE} parameter in
	 * {@link Message}.
	 * 
	 * @param message
	 *            the message that is to be interpreted.
	 * @param user
	 *            the user who sent the message.
	 */
	void interpretMessage(Message message, ChatUser user);
}
