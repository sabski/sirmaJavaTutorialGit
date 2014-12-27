package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.managers.UIControler;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.utils.CommonUtils;
import com.sirma.itt.javacourse.chat.common.utils.UIColegue;

/**
 * 
 * @author siliev
 * 
 */
public class ChatsPanel extends JPanel implements UIColegue {

	private static final long serialVersionUID = -3781827111159603799L;

	private static Logger log = Logger.getLogger(ChatsPanel.class);
	private JTabbedPane tabbedPane;
	private UIControler controler = UIControler.getInstance();
	private List<ChatWindow> tabs;

	/**
	 * Constructor
	 */
	public ChatsPanel() {
		tabs = new ArrayList<ChatWindow>();
		setUp();
	}

	private void setUp() {
		// TODO Full set up off the tabbed pane.
		tabbedPane = new JTabbedPane();
		JPanel papel = this;
		papel.add(tabbedPane);
		tabbedPane.setPreferredSize(new Dimension(380, 310));
		registerComponent();
	}

	public void addNewTab(Message info) {
		log.info("Adding tab");
		ChatWindow chatWindow = createNewPanel(info);
		tabbedPane.add(info.getContent(), chatWindow);
		tabbedPane.invalidate();
		tabs.add(chatWindow);
	}

	private ChatWindow createNewPanel(Message info) {
		log.info("Creating new window");
		ChatWindow panel = new ChatWindow();
		panel.setChatID(info.getChatRoomId());
		panel.setUserNames(Arrays.asList(CommonUtils.splitList(info.getContent())));
		return panel;
	}

	@Override
	public void sendUIEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void respondToEvent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerComponent() {
		controler.registerChatPanel(this);
	}

	public Long getChatId() {
		ChatWindow window = (ChatWindow) tabbedPane.getSelectedComponent();
		return window.getChatID();
	}

	public void processMessage(Message message) {
		for (ChatWindow tab : tabs) {
			if (tab.getChatID() == message.getChatRoomId()) {
				tab.displayMessage(message);
				break;
			}
		}
	}

	public boolean checkPanels(List<String> list) {
		for (ChatWindow tab : tabs) {
			if (tab.getUserNames().containsAll(list)
					&& list.containsAll(tab.getUserNames())) {
				return false;
			}
		}
		return true;
	}

	public Long getSelectedChat() {
		ChatWindow window = (ChatWindow) tabbedPane.getSelectedComponent();
		return window.getChatID();
	}
}
