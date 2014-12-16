package com.sirma.itt.javacourse.chat.client.managers;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.client.ui.MainClientWindow;
import com.sirma.itt.javacourse.chat.common.utils.UIMediator;

/**
 * @author siliev
 * 
 */
public class UIControler implements UIMediator {

	private static Logger log = Logger.getLogger(UIControler.class);
	private static UIControler instance;
	private ChatsPanel chatsPanel;
	private MainClientWindow mainWindow;

	private UIControler() {

	}

	public static UIControler getInstance() {
		if (instance == null) {
			instance = new UIControler();
		}
		return instance;
	}

	@Override
	public void processUIEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendUIEvent() {
		// TODO Auto-generated method stub

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
		String[] users = content.replaceAll("\\[", "").replaceAll("\\]", "")
				.split(", ");
		mainWindow.getUsers().clear();
		for (String user : users) {
			log.info(user);
			mainWindow.getUsers().addElement(user);
		}
		mainWindow.getUserList().invalidate();
	}

	public void registerMainWindow(MainClientWindow mainClientWindow) {
		this.mainWindow = mainClientWindow;
	}

}
