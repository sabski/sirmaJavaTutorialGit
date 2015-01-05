package com.sirma.itt.javacourse.chat.client.ui;

import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sirma.itt.javacourse.chat.common.Message;

/**
 * @author siliev
 * 
 */
public class ChatWindow extends JPanel {

	private static final long serialVersionUID = 2804226115505001629L;
	private long chatID;
	private List<String> userNames;
	private JTextArea textArea;

	public ChatWindow() {
		textArea = new JTextArea(16, 39);
		//textArea.setSize(200, 300);
		textArea.setEditable(false);
		JScrollPane scrollableTextArea = new JScrollPane(textArea);
		scrollableTextArea
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollableTextArea);
		this.setSize(400, 500);
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
