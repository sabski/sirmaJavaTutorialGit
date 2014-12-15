package com.sirma.itt.javacourse.chat.client.managers;

import com.sirma.itt.javacourse.chat.client.ui.ChatsPanel;
import com.sirma.itt.javacourse.chat.common.utils.UIMediator;

/**
 * @author siliev
 * 
 */
public class UIControler implements UIMediator {

	private static UIControler instance;
	private ChatsPanel chatsPanel;

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

}
