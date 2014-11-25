package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.client;

import java.awt.GridLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class MessageClientGUI extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(MessageClientGUI.class);
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
		client = new MessageClient(this);
		client.start();
		listenersSetUp();
		// Frame settings
		JFrame mainWindow = this;
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(300, 200);
		mainWindow.setVisible(true);
		mainWindow.setLayout(new GridLayout(3, 1));
		mainWindow.add(messageArea);
		mainWindow.add(messageField);
		mainWindow.add(sendButton);
		mainWindow.addWindowListener(new WindowAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				if (client.isAlive()) {
					client.stopClient();
				}
				System.exit(0);
			}

		});
	}

	private void listenersSetUp() {
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				originator.setState(messageField.getText());
				mementos.add(0,originator.saveToMemento());
				client.sendMessageToServer(messageField.getText());
				index = -1;
				messageField.setText("");
			}
		});

		Action keyDown = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				index--;
				if (index > -1) {
					messageField.setText(originator.restoreFromMemento(mementos.get(index)));
				}else {
					index = -1;
				}
			}
		};

		Action keyUp = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				if (mementos.size() > index) {
					messageField.setText(originator.restoreFromMemento(mementos.get(index)));
				}else {
					index = mementos.size()-1;
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

}
