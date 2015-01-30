package com.sirma.itt.javacourse.chat.client.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.managers.ClientInfo;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.client.ui.MainClientWindow;
import com.sirma.itt.javacourse.chat.client.ui.componnents.PopUpMessages;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageType;
import com.sirma.itt.javacourse.chat.common.utils.CommonUtils;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

/**
 * This class holds references to UI components that interact together.
 * 
 * @author siliev
 * 
 */
public class UIControler {

	private static final Logger LOGGER = Logger.getLogger(UIControler.class);

	private ChatsPanel chatsPanel;
	private MainClientWindow mainWindow;
	private ClientThread clientThread;
	private ClientInfo clientInfo;
	private PopUpMessages popUps;

	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	public UIControler() {
		this.mainWindow = new MainClientWindow(this);
		popUps = new PopUpMessages();
		clientInfo = ClientInfo.getInstance();
	}

	public void registerChatPanel(ChatsPanel chatsPanel) {
		this.chatsPanel = chatsPanel;
	}

	/**
	 * @return the chatsPanel
	 */
	public ChatsPanel getChatsPanel() {
		return chatsPanel;
	}

	/**
	 * @return the thread
	 */
	public ClientThread getThread() {
		return clientThread;
	}

	/**
	 * @param thread
	 *            the thread to set
	 */
	public void setThread(ClientThread thread) {
		this.clientThread = thread;
	}

	public PopUpMessages getPopUps() {
		return popUps;
	}

	public void setPopUps(PopUpMessages popUps) {
		this.popUps = popUps;
	}

	/**
	 * Updates the user list.
	 * 
	 * @param usersList
	 *            the new userList that must be processed.
	 */
	public void updateUserList(String usersList) {
		String[] users = CommonUtils.splitList(usersList);
		mainWindow.getUsers().clear();
		for (String user : users) {
			LOGGER.info(user);
			mainWindow.getUsers().addElement(user);
		}
		mainWindow.getUserList().invalidate();
	}

	/**
	 * Adds a single user to the user list.
	 * 
	 * @param content
	 *            the user to be added.
	 */
	public void updateUserListAdd(Message message) {
		mainWindow.getUsers().addElement(message.getContent());
		mainWindow.getUserList().invalidate();
		message.setContent(LanguageController.getWord("connectmessage") + " "
				+ message.getContent());
		displayMessage(message);
	}

	/**
	 * Removes a single user from the user list.
	 * 
	 * @param content
	 *            the user to be removed.
	 */
	public void updateUserListRemove(String content) {
		mainWindow.getUsers().removeElement(content);
		mainWindow.getUserList().invalidate();
	}

	public void registerMainWindow(MainClientWindow mainClientWindow) {
		this.mainWindow = mainClientWindow;
	}

	/**
	 * Sends a message to a speified chat room.
	 * 
	 * @param text
	 *            the text to send.
	 */
	public void sendMessage(String text) {
		clientThread.sendMessage(clientThread.getManager().generateMessage(
				MessageType.MESSAGE, chatsPanel.getSelectedChat(), text,
				clientInfo.getUserName()));

	}

	/**
	 * @return the mainWindow
	 */
	public MainClientWindow getMainWindow() {
		return mainWindow;
	}

	/**
	 * 
	 * @param list
	 *            the user names for the new chat room.
	 */
	public void createChatRoom(List<String> list) {
		if (list.contains(clientInfo.getUserName())) {
			list.remove(clientInfo.getUserName());
		}
		if (list.size() != 0 && chatsPanel.checkPanels(list)) {
			clientThread.sendMessage(new Message(list.toString(), 0,
					MessageType.STARTCHAT, clientInfo.getUserName()));
		} else {
			chatsPanel.showTab(list);
		}
	}

	public void toogleText() {
		mainWindow.toogleText();
	}

	public void serverDisconnect() {
		popUps.serverDisconnect();
		mainWindow.toogleText();
		chatsPanel.resetChats();
	}

	public void welcomeClient(Message message) {
		popUps.welcomeClient(message);
		mainWindow.setTitle(LanguageController.getWord("titleclient") + " "
				+ message.getContent());
	}

	public void userNameRejected(Message message) {
		popUps.showDialog(message);
		String username = inputUserName();
		if (username != null) {
			clientThread.sendMessage(clientThread.getManager().generateMessage(
					MessageType.CONNECT, 0, username, null));
		}

	}

	/**
	 * Opens a dialog window so the user can enter a user name he wants.
	 * 
	 * @return the user name that was inputed by the user.
	 */
	public String inputUserName() {
		LOGGER.info("Input user name");
		String name = null;
		name = popUps.inputUserName();
		if (name != null) {
			chatsPanel.resetChats();
		} else {
			clientThread.interrupt();
		}
		mainWindow.toogleText();
		return name;
	}

	/**
	 * Creates a new UI tab.
	 * 
	 * @param message
	 *            the message that tell us the information about the new tab.
	 */
	public void createTab(Message message) {
		chatsPanel.addNewTab(message);
	}

	/**
	 * Displays a message on to a UI tab.
	 * 
	 * 
	 * @param message
	 *            the message that is to be displayed.
	 */
	public void displayMessage(Message message) {
		chatsPanel.processMessage(message);
	}
}
