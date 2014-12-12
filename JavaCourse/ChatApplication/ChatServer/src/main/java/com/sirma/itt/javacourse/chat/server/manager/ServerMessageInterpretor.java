package com.sirma.itt.javacourse.chat.server.manager;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageInterpretor;

/**
 * 
 * @author siliev
 * 
 */
public class ServerMessageInterpretor implements MessageInterpretor {

	private static Logger log = Logger
			.getLogger(ServerMessageInterpretor.class);

	//private UserManager manager = UserManager.getInstance();

	@Override
	public void interpretMessage(Message message, ChatUser user) {
		switch (message.getMessageType()) {
		case CONNECT:
			
			break;
		case MESSAGE:
				
			break;
		case DISCONNECT:

			break;
		case STARTCHAT:

			break;
		default:
			log.info("Unsuported type " + message.getMessageType());
			break;
		}
	}

	@Override
	public Message generateMessage(String type, long id, String content,
			String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
