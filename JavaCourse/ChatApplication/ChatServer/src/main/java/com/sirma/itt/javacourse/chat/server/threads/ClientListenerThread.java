package com.sirma.itt.javacourse.chat.server.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.ChatUser;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.server.manager.ServerMessageInterpreter;
import com.sirma.itt.javacourse.chat.server.manager.UserManager;

/**
 * @author siliev
 * 
 */
public class ClientListenerThread extends Thread {

	private static Logger log = Logger.getLogger(ClientListenerThread.class);

	private ChatUser user;
	private ServerMessageInterpreter interpretor;
	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private UserManager manager;

	/**
	 * 
	 * 
	 * @param user
	 *            the user that is associated with this thread.
	 */
	public ClientListenerThread(ChatUser user) {
		this.user = user;
		manager = UserManager.getInstance();
		interpretor = manager.getInterpretator();
		try {
			inputStream = new ObjectInputStream(user.getInputStream());
			outputStream = new ObjectOutputStream(user.getOutputStream());
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * Gets the user that the thread is monitoring.
	 * 
	 * @return the user that is associated with this thread.
	 */
	public ChatUser getUser() {
		return user;
	}

	@Override
	public void run() {
		log.info("Started listening to messages from " + user.getUsername());
		try {
			readClientMessage();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * Read the client messages and invokes a response to them.
	 * 
	 * @throws IOException
	 */
	public void readClientMessage() throws IOException {

		Message message = null;
		try {
			while ((message = (Message) inputStream.readObject()) != null) {
				log.info("Read message " + message.getChatRoomId() + " "
						+ message.getMessageType() + " " + message.getContent());
				interpretor.interpretMessage(message, user);
			}
		} catch (ClassNotFoundException e) {

			log.error(e.getMessage(), e);
		} finally {
			manager.disconnectUser(this);
		}
	}

	/**
	 * Sends a message to the user.
	 * 
	 * @param message
	 *            the message that is sent to the user.
	 */
	public void sendMessge(Message message) {
		if (user != null) {
			try {
				outputStream.writeObject(message);
				log.info("Message was sent : " + message);
				outputStream.flush();
				outputStream.reset();
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
}
