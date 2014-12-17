package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.Dimension;
import java.util.Date;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

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
	private JTextArea textArea;
	private JScrollPane scroll;

	public ChatWindow() {
		textArea = new JTextArea();
		textArea.setSize(300, 200);
		textArea.setEditable(false);
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scroll);
	}

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
		textArea.setText(textArea.getText() + "\n" + new Date().toString()
				+ " " + message.getAuthor() + " : " + message.getContent());

		textArea.invalidate();
	}

}
