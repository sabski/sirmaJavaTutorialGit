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
import com.sirma.itt.javacourse.chat.common.utils.UIColegue;

/**
 * @author siliev
 * 
 */
public class TextArea extends JPanel implements UIColegue {

	private static final long serialVersionUID = 8138842498862853077L;
	private static Logger log = Logger.getLogger(TextArea.class);

	private MessageOriginator originator;
	private List<MessageMemento> mementos;
	private int index;
	private JTextField messageField;
	private JButton sendButton;
	private JButton connectButton;
	private JButton languageButton;
	private UIControler controler;

	/**
	 * @param connectButton
	 * 
	 */
	public TextArea(JButton connectButton) {
		this.connectButton = connectButton;
		mementos = new ArrayList<>();
		originator = new MessageOriginator();
		controler = UIControler.getInstance();
		setUP();
	}

	/**
	 * 
	 */
	private void setUP() {
		JPanel mainWindow = this;
		mainWindow.setLayout(new FlowLayout());
		messageField = new JTextField();
		sendButton = new JButton("Send");
		languageButton = new JButton("EN/BG");
		messageField.setPreferredSize(new Dimension(250, 30));
		mainWindow.add(languageButton);
		mainWindow.add(connectButton);
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
				sendMessage(messageField.getText());
			}

		});

		languageButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Write the action.

			}
		});

		Action keyDown = new AbstractAction() {

			private static final long serialVersionUID = 11L;

			@Override
			public void actionPerformed(ActionEvent e) {
				index--;
				log.info("Event " + e.getActionCommand());
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
				log.info("Event " + e.getActionCommand());
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

	}

	private void sendMessage(String text) {
		// TODO Implement send message;
		
		controler.sendMessage(text);
		originator.setState(messageField.getText());
		mementos.add(0, originator.saveToMemento());
		index = -1;
		messageField.setText("");
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
		// TODO Auto-generated method stub
		// controler.registerTextArea(this);
	}
}
