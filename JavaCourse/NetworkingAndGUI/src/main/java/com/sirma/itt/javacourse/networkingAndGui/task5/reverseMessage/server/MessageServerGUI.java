package com.sirma.itt.javacourse.networkingAndGui.task5.reverseMessage.server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Simeon Iliev
 */
public class MessageServerGUI extends JFrame {

	private JTextArea messageArea;
	private JButton startButton;
	private JButton stopButton;
	private MessageServer server;

	/**
	 *
	 */
	public MessageServerGUI() {
		// TODO set me up;
		setUp();

	}

	private void setUp() {
		// TODO be awesome :)
		JFrame mainWindow = this;
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		messageArea = new JTextArea();
		mainWindow.setSize(300, 250);
		mainWindow.setLayout(new GridLayout(2, 1));

		messageArea.setEditable(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		createButtonListners();
		mainWindow.add(buttonPanel);
		mainWindow.add(messageArea);

		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);

		mainWindow.addWindowListener(new WindowAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				server.stopServer();
				System.exit(0);
			}

		});

	}

	private void createButtonListners() {
		// TODO Auto-generated method stub
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				server = new MessageServer(MessageServerGUI.this);
				server.start();
			}
		});

		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				server.stopServer();
			}
		});
	}

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MessageServerGUI();
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

}
