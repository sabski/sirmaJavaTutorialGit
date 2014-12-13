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
public interface MessageInterpretor {

	public Message generateMessage(TYPE type, long id, String content,
			String author);

	void interpretMessage(Message message, ChatUser user);
}
