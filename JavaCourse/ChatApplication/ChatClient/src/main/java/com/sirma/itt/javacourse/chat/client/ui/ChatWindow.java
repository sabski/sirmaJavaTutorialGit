package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.Dimension;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.sirma.itt.javacourse.chat.common.Message;

/**
 * @author siliev
 * 
 */
public class ChatWindow extends JScrollPane {

	private static final long serialVersionUID = 2804226115505001629L;
	private long chatID;
	private List<String> userNames;
	private JTextArea textArea;
	private JPanel panel;

	public ChatWindow() {
		panel = new JPanel();
		textArea = new JTextArea();
		//textArea.setSize(300, 200);
		textArea.setEditable(false);
		//textArea.setPreferredSize(new Dimension(450, 390));
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setPreferredSize(new Dimension(450, 390));
		panel.add(textArea);
		this.add(panel);
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
