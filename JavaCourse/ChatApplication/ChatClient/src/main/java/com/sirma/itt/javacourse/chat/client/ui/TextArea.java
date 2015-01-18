package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.MessageMemento;
import com.sirma.itt.javacourse.MessageOriginator;
import com.sirma.itt.javacourse.chat.client.managers.UIControler;
import com.sirma.itt.javacourse.chat.client.ui.componnents.LimitTextField;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController.LANGUGES;
import com.sirma.itt.javacourse.chat.common.utils.UIColegue;

/**
 * The Bottom panel of the client window.
 * 
 * @author siliev
 * 
 */
public class TextArea extends JPanel implements UIColegue {

	private static final long serialVersionUID = 8138842498862853077L;
	private static final Logger LOGGER = Logger.getLogger(TextArea.class);

	private MessageOriginator originator;
	private List<MessageMemento> mementos;
	private int index;
	private JTextField messageField;
	private JButton sendButton;
	private JButton connectButton;
	private JButton disconnectButton;
	private JButton languageButton;
	private UIControler controler;

	/**
	 * The Bottom panel of the client window.
	 * 
	 * @param connectButton
	 *            the connect button.
	 * @param disconnectButton
	 *            the disconnect button.
	 * 
	 */
	public TextArea(JButton connectButton, JButton disconnectButton) {
		this.connectButton = connectButton;
		this.disconnectButton = disconnectButton;
		mementos = new ArrayList<>();
		originator = new MessageOriginator();
		controler = UIControler.getInstance();
		setUP();
	}

	/**
	 * Sets up the UI settings.
	 */
	private void setUP() {
		JPanel mainWindow = this;
		mainWindow.setLayout(new FlowLayout());
		messageField = new JTextField();
		messageField.setDocument(new LimitTextField(200));
		sendButton = new JButton(LanguageController.getWord("send"));
		languageButton = new JButton(LanguageController.getWord("enbg"));
		messageField.setPreferredSize(new Dimension(250, 30));
		messageField.setEditable(false);
		mainWindow.add(languageButton);
		mainWindow.add(connectButton);
		mainWindow.add(disconnectButton);
		mainWindow.add(messageField);
		mainWindow.add(sendButton);
		listenersSetUp();
	}

	/**
	 * Sets up the lister for the button and the action commands for the key
	 * strokes.
	 */
	private void listenersSetUp() {
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.info("The lenght of the message is : "
						+ messageField.getText().length());
				sendMessage(messageField.getText());
			}

		});
		languageButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.info("Language is "
						+ LanguageController.getCurrentLanguage());
				if (LanguageController.getCurrentLanguage().equals(
						LANGUGES.BG.toString())) {
					LanguageController.setLanguage(LANGUGES.EN.toString());
				} else {
					LanguageController.setLanguage(LANGUGES.BG.toString());
				}
				LanguageController.invalidateComponents();
				invalidate();
			}
		});

		Action keyDown = new AbstractAction() {

			private static final long serialVersionUID = 11L;

			@Override
			public void actionPerformed(ActionEvent e) {
				index--;
				LOGGER.info("Event " + e.getActionCommand());
				if (index > -1) {
					messageField.setText(originator.restoreFromMemento(mementos
							.get(index)));
				} else {
					index = -1;
				}
			}
		};

		Action keyUp = new AbstractAction() {

			private static final long serialVersionUID = 10L;

			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				LOGGER.info("Event " + e.getActionCommand());
				if (mementos.size() > index) {
					messageField.setText(originator.restoreFromMemento(mementos
							.get(index)));
				} else {
					index = mementos.size() - 1;
				}
			}
		};

		Action enterAction = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage(messageField.getText());
			}
		};

		messageField.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),
				"keyDown");
		messageField.getInputMap().put(KeyStroke.getKeyStroke("UP"), "keyUp");
		messageField.getInputMap().put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");

		messageField.getActionMap().put("enter", enterAction);
		messageField.getActionMap().put("keyDown", keyDown);
		messageField.getActionMap().put("keyUp", keyUp);

		LanguageController.addComponent("connect", connectButton);
		LanguageController.addComponent("disconnect", disconnectButton);
		LanguageController.addComponent("enbg", languageButton);
		LanguageController.addComponent("send", sendButton);
	}

	/**
	 * Sends a message to the server and clears up the text area.
	 * 
	 * @param text
	 *            the text for the message.
	 */
	private void sendMessage(String text) {
		text = text.substring(0, 1).toUpperCase() + text.substring(1);
		controler.sendMessage(text);
		originator.setState(messageField.getText());
		mementos.add(0, originator.saveToMemento());
		index = -1;
		messageField.setText("");
	}

	@Override
	public void registerComponent() {
		// TODO Auto-generated method stubs
		// controler.registerTextArea(this);
	}

	/**
	 * Switches the text field editable status.
	 */
	public void toogleText() {
		if (messageField.isEditable()) {
			messageField.setEditable(false);
		} else {
			messageField.setEditable(true);
		}
		connectButton.setEnabled(!connectButton.isEnabled());
		disconnectButton.setEnabled(!disconnectButton.isEnabled());
	}
}
