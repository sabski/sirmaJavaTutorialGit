package com.sirma.itt.javacourse.chat.client.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.interfaces.UserController;
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
public class UIControler implements UserController {

	private static final Logger LOGGER = Logger.getLogger(UIControler.class);

	private ChatsPanel chatsPanel;
	private MainClientWindow mainWindow;
	private ClientThread clientThread;
	private ClientInfo clientInfo;
	private PopUpMessages popUps;

	public UIControler() {
		this.mainWindow = new MainClientWindow(this);
		popUps = new PopUpMessages();
		clientInfo = ClientInfo.getInstance();
	}

	public void registerChatPanel(ChatsPanel chatsPanel) {
		this.chatsPanel = chatsPanel;
	}


	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
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

	@Override
	public void updateUserList(String usersList) {
		String[] users = CommonUtils.splitList(usersList);
		mainWindow.getUsers().clear();
		for (String user : users) {
			LOGGER.info(user);
			mainWindow.getUsers().addElement(user);
		}
		mainWindow.getUserList().invalidate();
	}

	@Override
	public void updateUserListAdd(Message message) {
		mainWindow.getUsers().addElement(message.getContent());
		mainWindow.getUserList().invalidate();
		message.setContent(LanguageController.getWord("connectmessage") + " "
				+ message.getContent());
		displayMessage(message);
	}

	@Override
	public void updateUserListRemove(String content) {
		mainWindow.getUsers().removeElement(content);
		mainWindow.getUserList().invalidate();
	}

	@Override
	public void registerMainWindow(MainClientWindow mainClientWindow) {
		this.mainWindow = mainClientWindow;
	}

	@Override
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

	@Override
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

	@Override
	public void toogleText() {
		mainWindow.toogleText();
	}

	@Override
	public void serverDisconnect() {
		popUps.serverDisconnect();
		mainWindow.toogleText();
		chatsPanel.resetChats();
	}

	@Override
	public void welcomeClient(Message message) {
		popUps.welcomeClient(message);
		mainWindow.setTitle(LanguageController.getWord("titleclient") + " "
				+ message.getContent());
	}

	@Override
	public void userNameRejected(Message message) {
		popUps.showDialog(message);
		String username = inputUserName();
		if (username != null) {
			clientThread.sendMessage(clientThread.getManager().generateMessage(
					MessageType.CONNECT, 0, username, null));
		}

	}

	@Override
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

	@Override
	public void createTab(Message message) {
		chatsPanel.addNewTab(message);
	}

	@Override
	public void displayMessage(Message message) {
		chatsPanel.processMessage(message);
	}
}
