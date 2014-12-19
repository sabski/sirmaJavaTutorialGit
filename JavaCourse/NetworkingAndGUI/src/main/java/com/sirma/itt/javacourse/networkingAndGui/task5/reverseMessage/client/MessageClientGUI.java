package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import com.sirma.itt.javacourse.MessageMemento;
import com.sirma.itt.javacourse.MessageOriginator;

/**
 * UI for the {@link MessageClient} client class.
 * 
 * @author Simeon Iliev
 */
public class MessageClientGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private MessageOriginator originator;
	private List<MessageMemento> mementos;
	private int index;
	private JButton sendButton;
	private JTextArea messageArea;
	private JTextField messageField;
	private MessageClient client;

	/**
	 * Basic constructor.
	 */
	public MessageClientGUI() {
		setUp();
	}

	/**
	 * Sets up all the frame variables and preferences.
	 */
	private void setUp() {
		// Component variables and other objects
		index = -1;
		originator = new MessageOriginator();
		mementos = new ArrayList<MessageMemento>();
		sendButton = new JButton("Send");
		setMessageArea(new JTextArea());
		messageField = new JTextField();
		messageField.setPreferredSize(new Dimension(150, 30));
		client = new MessageClient(this);
		client.start();
		messageArea.setEditable(false);
		listenersSetUp();
		// Frame settings
		JFrame mainWindow = this;
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setPreferredSize(new Dimension(300, 200));

		mainWindow.setLayout(new BorderLayout());
		mainWindow.add(messageArea, BorderLayout.CENTER);
		JPanel messagePanel = new JPanel();
		messagePanel.add(messageField);
		messagePanel.add(sendButton);
		messagePanel.setPreferredSize(new Dimension(300, 40));
		mainWindow.add(messagePanel, BorderLayout.SOUTH);
		mainWindow.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (client.isAlive()) {
					client.interrupt();
				}
				System.exit(0);
			}

		});
		mainWindow.setVisible(true);
		mainWindow.pack();
	}

	/**
	 * Sets up the lister for the button and the action commands for the key strokes.
	 */
	private void listenersSetUp() {
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage(messageField.getText());
			}

		});

		Action keyDown = new AbstractAction() {

			private static final long serialVersionUID = 11L;

			@Override
			public void actionPerformed(ActionEvent e) {
				index--;
				if (index > -1) {
					messageField.setText(originator.restoreFromMemento(mementos.get(index)));
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
				if (mementos.size() > index) {
					messageField.setText(originator.restoreFromMemento(mementos.get(index)));
				} else {
					index = mementos.size() - 1;
				}
			}
		};

		messageField.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "keyDown");
		messageField.getInputMap().put(KeyStroke.getKeyStroke("UP"), "keyUp");

		messageField.getActionMap().put("keyDown", keyDown);
		messageField.getActionMap().put("keyUp", keyUp);

	}

	/**
	 * Getter method for messageArea.
	 * 
	 * @return the messageArea
	 */
	public JTextArea getMessageArea() {
		return messageArea;
	}

	/**
	 * Setter method for messageArea.
	 * 
	 * @param messageArea
	 *            the messageArea to set
	 */
	public void setMessageArea(JTextArea messageArea) {
		this.messageArea = messageArea;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		new MessageClientGUI();
	}

	/**
	 * Send a message to the server.
	 * 
	 * @param message
	 *            the message to be sent to the server
	 */
	protected void sendMessage(String message) {
		originator.setState(messageField.getText());
		mementos.add(0, originator.saveToMemento());
		client.sendMessageToServer(messageField.getText());
		index = -1;
		messageField.setText("");
	}
}
