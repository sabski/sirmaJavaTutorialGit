package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sirma.itt.javacourse.chat.common.Message;

/**
 * This class represent a window that is a chat to a person or a group of
 * people.
 * 
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
		textArea.setEditable(false);
		JScrollPane scrollableTextArea = new JScrollPane(textArea);
		scrollableTextArea
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setLayout(new BorderLayout());
		add(scrollableTextArea, BorderLayout.CENTER);
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

	/**
	 * Displays a message to that was sent to the user for this window.
	 * 
	 * @param message
	 *            the message that is to be displayed to the user
	 */
	public void displayMessage(Message message) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

		textArea.setText(textArea.getText() + "\n<" + format.format(new Date())
				+ ">" + message.getAuthor() + " : " + message.getContent());

		textArea.invalidate();
	}
}
