package com.sirma.itt.javacourse.chat.client.interfaces;

import java.util.List;

import com.sirma.itt.javacourse.chat.client.managers.ClientInfo;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.client.ui.MainClientWindow;
import com.sirma.itt.javacourse.chat.common.Message;

/**
 * User controller interface.
 * 
 * @author Simon Iliev
 * 
 */
public interface UserController {

	/**
	 * Updates the user list.
	 * 
	 * @param usersList
	 *            the new userList that must be processed.
	 */
	public void updateUserList(String usersList);

	/**
	 * Adds a single user to the user list.
	 * 
	 * @param content
	 *            the user to be added.
	 */
	public void updateUserListAdd(Message message);

	/**
	 * Removes a single user from the user list.
	 * 
	 * @param content
	 *            the user to be removed.
	 */
	public void updateUserListRemove(String content);

	/**
	 * Sends a message to a specified chat room.
	 * 
	 * @param text
	 *            the text to send.
	 */
	public void sendMessage(String text);

	/**
	 * 
	 * @param list
	 *            the user names for the new chat room.
	 */
	public void createChatRoom(List<String> list);

	/**
	 * Opens a dialog window so the user can enter a user name he wants.
	 * 
	 * @return the user name that was inputed by the user.
	 */
	public String inputUserName();

	/**
	 * Creates a new UI tab.
	 * 
	 * @param message
	 *            the message that tell us the information about the new tab.
	 */
	public void createTab(Message message);

	/**
	 * Displays a message on to a UI tab.
	 * 
	 * 
	 * @param message
	 *            the message that is to be displayed.
	 */
	public void displayMessage(Message message);

	/**
	 * Toggles on and off buttons.
	 */
	public void toogleText();

	/**
	 * Displays a message that he server was shut down.
	 */
	public void serverDisconnect();

	/**
	 * Shows a welcome popup.
	 * 
	 * @param message
	 *            the welcome message from the server.
	 */
	public void welcomeClient(Message message);

	/**
	 * Shows the user that the user name he entered was rejected.
	 * 
	 * @param message
	 *            the rejected message from the server.
	 */
	public void userNameRejected(Message message);

	/**
	 * Registers the main window.
	 * 
	 * @param mainClientWindow
	 *            the main window to be registered.
	 */
	public void registerMainWindow(MainClientWindow mainClientWindow);

	/**
	 * @return the thread
	 */
	public ClientThread getThread();

	/**
	 * @param thread
	 *            the thread to set
	 */
	public void setThread(ClientThread thread);

	public ClientInfo getClientInfo();

	public void setClientInfo(ClientInfo clientInfo);

	public void registerChatPanel(ChatsPanel chatsPanel);
}
