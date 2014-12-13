/**
 * 
 */
package com.sirma.itt.javacourse.chat.client.managers;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
import com.sirma.itt.javacourse.chat.common.utils.LanguageControler;
import com.sirma.itt.javacourse.chat.common.MessageInterpretor;

/**
 * @author siliev
 * 
 */
public class ClientMessageInterpretor implements MessageInterpretor {

	private Logger log = Logger.getLogger(ClientMessageInterpretor.class);
	private ClientThread clientThread;

	public ClientMessageInterpretor(ClientThread clientThread) {
		this.clientThread = clientThread;
	}

	@Override
	public Message generateMessage(TYPE type, long id, String content,
			String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void interpretMessage(Message message, ChatUser user) {

		switch (message.getMessageType()) {
		case MESSAGE:

			break;
		case STARTCHAT:
			//clientThread.sendMessage(new Message(, 0, TYPE.STARTCHAT, user.getUsername()));
			break;
		case APPROVED:
			JOptionPane.showMessageDialog(null, message.getContent());
			break;
		case REFUSED:
			JOptionPane.showMessageDialog(null, message.getContent());
			clientThread.sendMessage(new Message(ClientMessageInterpretor
					.inputUserName(), 0, TYPE.CONNECT, null));
			break;
		case SERVER:

			break;
		default:
			log.info("Unsuported type " + message.getMessageType());
			break;
		}
		// APPROVED, REFUSED
	}

	public static String inputUserName() {
		String name = null;
		name = JOptionPane.showInputDialog(LanguageControler
				.getWord("inputUsername"));
		return name;
	}
}
