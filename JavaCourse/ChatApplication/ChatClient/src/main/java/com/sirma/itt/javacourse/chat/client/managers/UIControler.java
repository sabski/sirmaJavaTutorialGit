package com.sirma.itt.javacourse.chat.client.managers;

import java.util.List;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.client.ui.MainClientWindow;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.MessageType;
import com.sirma.itt.javacourse.chat.common.utils.CommonUtils;

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

	public void updateUserList(String content) {
		String[] users = CommonUtils.splitList(content);
		mainWindow.getUsers().clear();
		for (String user : users) {
			LOGGER.info(user);
			mainWindow.getUsers().addElement(user);
		}
		mainWindow.getUserList().invalidate();
	}

	public void updateUserListAdd(String content) {
		mainWindow.getUsers().addElement(content);
		mainWindow.getUserList().invalidate();
	}

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
		}
	}

}
