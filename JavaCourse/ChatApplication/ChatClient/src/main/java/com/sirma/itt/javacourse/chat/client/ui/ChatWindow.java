package com.sirma.itt.javacourse.chat.client.ui;

import java.util.List;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.common.Message;

/**
 * @author siliev
 * 
 */
public class ChatWindow extends JTextArea {

	private static final long serialVersionUID = 2804226115505001629L;
	private static Logger log = Logger.getLogger(ChatWindow.class);
	private long chatID;
	private List<String> userNames;

	/**
	 * @return the chatID
	 */
	public long getChatID() {
		return chatID;
	}

	/**
	 * @param chatID
	 *            the chatID to set
	 */
	public void setChatID(long chatID) {
		this.chatID = chatID;
	}

	/**
	 * @return the userNames
	 */
	public List<String> getUserNames() {
		return userNames;
	}

	/**
	 * @param userNames
	 *            the userNames to set
	 */
	public void setUserNames(List<String> userNames) {
		this.userNames = userNames;
	}

	public void displayMessage(Message message) {
		log.info(message);
	}

}
