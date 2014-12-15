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
import com.sirma.itt.javacourse.chat.common.MessageInterpreter;

/**
 * @author siliev
 * 
 */
public class ClientMessageInterpretor implements MessageInterpreter {

	private Logger log = Logger.getLogger(ClientMessageInterpretor.class);
	private ClientThread clientThread;
	private UIControler controler = UIControler.getInstance();

	public ClientMessageInterpretor(ClientThread clientThread) {
		this.clientThread = clientThread;
	}

	@Override
	public Message generateMessage(TYPE type, long id, String content,
			String author) {
		return new Message(content, id, type, author);
	}

	@Override
	public void interpretMessage(Message message, ChatUser user) {

		switch (message.getMessageType()) {
		case MESSAGE:
			displayMessage(message);
			break;
		case STARTCHAT:
			createNewChatWindow(message);
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
		case USERLIST:
			
			break;
		default:
			log.info("Unsuported type " + message.getMessageType());
			break;
		}
	}

	private void displayMessage(Message message) {
		// TODO Display message to proper screen.
		log.info("Message reseived : " + message);
		controler.getChatsPanel().processMessage(message);

	}

	private void createNewChatWindow(Message message) {
		// TODO Create a new chat window.
		log.info("Creating new chat room " + message);
		controler.getChatsPanel().addNewTab(message);
	}

	public static String inputUserName() {
		String name = null;
		name = JOptionPane.showInputDialog(LanguageControler
				.getWord("inputUsername"));
		return name;
	}
}
