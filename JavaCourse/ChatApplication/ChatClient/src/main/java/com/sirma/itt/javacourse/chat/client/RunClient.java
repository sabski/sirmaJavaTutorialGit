package com.sirma.itt.javacourse.chat.client;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.sirma.itt.javacourse.chat.client.controller.UIControler;

/**
 * Runner class for the Chat client application.
 * 
 * @author Simon Iliev
 * 
 */
public class RunClient {

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		new UIControler();
	}
}
