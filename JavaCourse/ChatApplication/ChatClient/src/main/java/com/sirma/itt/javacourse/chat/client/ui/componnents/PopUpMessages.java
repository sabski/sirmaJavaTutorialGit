package com.sirma.itt.javacourse.chat.client.ui.componnents;

import javax.swing.JOptionPane;

import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

/**
 * Class that shows pop up messages that inform the user of various events.
 * 
 * 
 * @author Simon Iliev
 * 
 */
public class PopUpMessages {

	/**
	 * Input dialog when the first user name the user has entered is not valid.
	 * 
	 * 
	 * @return the inputed user name.
	 */
	public String inputUserName() {
		String result = JOptionPane.showInputDialog(
				LanguageController.getWord("inputUsername"), null);
		return result;
	}

	/**
	 * Shows the user a notification message.
	 * 
	 * @param message
	 *            the message we want to show to the user.
	 */
	public void showDialog(Message message) {
		JOptionPane.showMessageDialog(null, message.getContent());
	}

	/**
	 * Shows a welcome message when the server has approved the user.
	 * 
	 * @param message
	 *            the message we want to show to the user.
	 */
	public void welcomeClient(Message message) {
		JOptionPane.showMessageDialog(
				null,
				LanguageController.getWord("welcomemessage") + " : "
						+ message.getContent());
	}

	/**
	 * Shows a message that the server has disconnected the client.
	 */
	public void serverDisconnect() {
		JOptionPane.showMessageDialog(null,
				LanguageController.getWord("servererror"), "Error",
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Shows a message that the server has disconnected the client.
	 */
	public void invalidData() {
		JOptionPane.showMessageDialog(null,
				LanguageController.getWord("invaliddata"), "Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
