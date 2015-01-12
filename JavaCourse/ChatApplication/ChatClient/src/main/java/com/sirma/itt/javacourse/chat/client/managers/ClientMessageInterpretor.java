package com.sirma.itt.javacourse.chat.client.managers;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;
import com.sirma.itt.javacourse.chat.common.MessageInterpreter;

/**
 * @author siliev
 * 
 */
public class ClientMessageInterpretor implements MessageInterpreter {

	private static final Logger LOGGER = Logger
			.getLogger(ClientMessageInterpretor.class);
	private ClientThread clientThread;
	private UIControler controler;
	private ClientInfo client;

	public ClientMessageInterpretor(ClientThread clientThread) {
		this.clientThread = clientThread;
		client = ClientInfo.getInstance();
		controler = UIControler.getInstance();
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
			clientApprover(message);
			break;
		case REFUSED:
			serverRefused(message);
			break;
		case SERVER:
			// TODO WHAT WHAT !!! - i can`t remember
			break;
		case USERLISTADD:
			LOGGER.info(message);
			controler.updateUserListAdd(message.getContent());
			message.setContent(LanguageController.getWord("connectmessage")
					+ " " + message.getContent());
			displayMessage(message);
			break;
		case USERLIST:
			LOGGER.info(message);
			controler.updateUserList(message.getContent());
			break;
		case USERLISTREMOVE:
			LOGGER.info(message);
			controler.updateUserListRemove(message.getContent());
			break;
		case DISCONNECT:
			LOGGER.info(message);
			message.setContent(LanguageController.getWord("disconnectmessage")
					+ " " + message.getContent());
			displayMessage(message);
			break;
		default:
			LOGGER.info("Unsuported type " + message.getMessageType());
			break;
		}
	}

	/**
	 * Shows that the server has refused the client.
	 * 
	 * @param message
	 *            the message that was received from the server.
	 */
	protected void serverRefused(Message message) {
		JOptionPane.showMessageDialog(null, message.getContent());
		clientThread.sendMessage(new Message(ClientMessageInterpretor
				.inputUserName(), 0, TYPE.CONNECT, null));
	}

	/**
	 * Shows that the server has approved the client.
	 * 
	 * @param message
	 *            the message that was received from the server.
	 */
	protected void clientApprover(Message message) {
		client.setUserName(message.getAuthor());
		controler.getMainWindow().setTitle(
				controler.getMainWindow().getTitle() + " "
						+ message.getAuthor());
		JOptionPane.showMessageDialog(
				null,
				LanguageController.getWord("welcomemessage") + " : "
						+ message.getContent());
	}

	/**
	 * Redirects the message to where it can be properly displayed.
	 * 
	 * @param message
	 *            the message that is to be displayed.
	 */
	protected void displayMessage(Message message) {
		LOGGER.info("Message reseived : " + message);
		controler.getChatsPanel().processMessage(message);
	}

	/**
	 * Creates a new chat tab for a chat with one or multiple users.
	 * 
	 * @param message
	 *            the message to create a new chat window and the data needed to
	 *            create the room.
	 */
	protected void createNewChatWindow(Message message) {
		LOGGER.info("Creating new chat room " + message);
		controler.getChatsPanel().addNewTab(message);
	}

	/**
	 * Opens a dialog window so the user can enter a user name he wants.
	 * 
	 * @return the user name that was inputed by the user.
	 */
	public static String inputUserName() {
		String name = null;
		name = JOptionPane.showInputDialog(
				LanguageController.getWord("inputUsername"), null);
		return name;
	}
}
