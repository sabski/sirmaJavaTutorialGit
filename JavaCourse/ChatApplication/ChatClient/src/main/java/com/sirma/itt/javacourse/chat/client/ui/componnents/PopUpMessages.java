package com.sirma.itt.javacourse.chat.client.ui.componnents;

import javax.swing.JOptionPane;

import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

public class PopUpMessages {

	public String inputUserName() {
		String result = JOptionPane.showInputDialog(
				LanguageController.getWord("inputUsername"), null);
		return result;
	}

	public void showDialog(Message message) {
		JOptionPane.showMessageDialog(null, message.getContent());
	}

	public void welcomeClient(Message message) {
		JOptionPane.showMessageDialog(
				null,
				LanguageController.getWord("welcomemessage") + " : "
						+ message.getContent());
	}

	public void serverDisconnect() {
		JOptionPane.showMessageDialog(null,
				LanguageController.getWord("servererror"), "Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
