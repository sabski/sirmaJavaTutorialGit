package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.utils.CommonUtils;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

/**
 * The main chat panel window.
 * 
 * 
 * @author siliev
 * 
 */
public class ChatsPanel extends JPanel {

	private static final long serialVersionUID = -3781827111159603799L;

	private static final Logger LOGGER = Logger.getLogger(ChatsPanel.class);
	private JTabbedPane tabbedPane;
	private List<ChatWindow> tabs;

	/**
	 * Constructor
	 */
	public ChatsPanel() {
		tabs = new ArrayList<ChatWindow>();
		setUp();
	}

	/**
	 * Sets up the UI settings.
	 */
	private void setUp() {
		tabbedPane = new JTabbedPane();
		JPanel panel = this;
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		panel.setLayout(new BorderLayout());
		panel.add(tabbedPane, BorderLayout.CENTER);
	}

	/**
	 * Adds the new tab to the tabbed pane.
	 * 
	 * 
	 * @param info
	 *            the information for the new tab.
	 */
	public void addNewTab(Message info) {
		LOGGER.info("Adding tab");
		ChatWindow chatWindow = createNewPanel(info);
		if (chatWindow.getChatID() == 0) {
			tabbedPane
					.add(LanguageController.getWord("commonroom"), chatWindow);
		} else {
			tabbedPane.add(info.getContent(), chatWindow);
		}
		tabbedPane.invalidate();
		tabs.add(chatWindow);
	}

	/**
	 * Creates a new chat window.
	 * 
	 * @param info
	 *            the information required for the new chat window.
	 * @return the new chat window.
	 */
	private ChatWindow createNewPanel(Message info) {
		LOGGER.info("Creating new window");
		ChatWindow panel = new ChatWindow();
		panel.setChatID(info.getChatRoomId());
		panel.setUserNames(Arrays.asList(CommonUtils.splitList(info
				.getContent())));
		return panel;
	}

	/**
	 * Gets the current selected chats id.
	 * 
	 * @return the selected chat windows ID.
	 */
	public Long getChatId() {
		ChatWindow window = (ChatWindow) tabbedPane.getSelectedComponent();
		return window.getChatID();
	}

	/**
	 * Send a message to be displayed in the proper tab.
	 * 
	 * @param message
	 *            the message that is tso be processed.
	 */
	public void processMessage(Message message) {
		for (ChatWindow tab : tabs) {
			if (tab.getChatID() == message.getChatRoomId()) {
				tab.displayMessage(message);
				break;
			}
		}
	}

	/**
	 * Checks if there is already a chat room with the people we have selected.
	 * 
	 * @param list
	 *            the list of users we want to check.
	 * @return true if there is no chat with the same user is there is then the
	 *         result is false.
	 */
	public boolean checkPanels(List<String> list) {
		for (ChatWindow tab : tabs) {
			if (tab.getUserNames().containsAll(list)
					&& list.containsAll(tab.getUserNames())) {
				if (tab.getChatID() != 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns the selected chats ID.
	 */
	public Long getSelectedChat() {
		ChatWindow window = (ChatWindow) tabbedPane.getSelectedComponent();
		return window.getChatID();
	}

	public void resetChats() {
		tabs.clear();
		tabbedPane.removeAll();
	}
}
