package com.sirma.itt.javacourse.chat.client.controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.managers.ClientInfo;
import com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.client.ui.MainClientWindow;
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
	private static final UIControler INSTANCE = new UIControler();
	private ChatsPanel chatsPanel;
	private MainClientWindow mainWindow;
	private ClientThread clientThread;
	private ClientInfo clientInfo;

	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	private UIControler() {
		clientInfo = ClientInfo.getInstance();
	}

	public static UIControler getInstance() {

		return INSTANCE;
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
	public void updateUserListAdd(String content) {
		mainWindow.getUsers().addElement(content);
		mainWindow.getUserList().invalidate();
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

	/**
	 * Sends a message to a speified chat room.
	 * 
	 * @param text
	 *            the text to send.
	 */
	public void sendMessage(String text) {
		clientThread.sendMessage(new Message(text,
				chatsPanel.getSelectedChat(), MessageType.MESSAGE, clientInfo
						.getUserName()));
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
		JOptionPane.showMessageDialog(null,
				LanguageController.getWord("servererror"), "Error",
				JOptionPane.ERROR_MESSAGE);
		mainWindow.toogleText();
		chatsPanel.resetChats();
	}

	public void welcomeClient(Message message) {
		JOptionPane.showMessageDialog(
				null,
				LanguageController.getWord("welcomemessage") + " : "
						+ message.getContent());
	}

	public void userNameRejected(Message message) {
		JOptionPane.showMessageDialog(null, message.getContent());
		String username = inputUserName();
		if (username != null) {
			clientThread.sendMessage(new Message(username, 0,
					MessageType.CONNECT, null));
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
		name = JOptionPane.showInputDialog(
				LanguageController.getWord("inputUsername"), null);
		if (name != null) {
			chatsPanel.resetChats();
		} else {
			clientThread.interrupt();
		}
		mainWindow.toogleText();
		return name;
	}
}
