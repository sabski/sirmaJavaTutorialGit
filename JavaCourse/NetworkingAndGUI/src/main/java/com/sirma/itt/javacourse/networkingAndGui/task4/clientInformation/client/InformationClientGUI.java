package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * The user interface of the Information client.
 * 
 * @author Simeon Iliev
 */
public class InformationClientGUI extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -6264959974014685722L;

	private JTextArea messageWingow;
	private JButton connectButton;
	private InformationClient client;

	/**
	 * Constructor for GUI class.
	 */
	public InformationClientGUI() {
		setUp();
	}

	/**
	 * Sets up all the UI variables.
	 */
	private void setUp() {
		final InformationClientGUI mainWindow = this;
		connectButton = new JButton("Connect");
		messageWingow = new JTextArea();
		messageWingow.setEditable(false);

		mainWindow.setLayout(new BorderLayout());
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client = new InformationClient(mainWindow);
				client.start();
			}
		});
		mainWindow.add(connectButton, BorderLayout.NORTH);
		mainWindow.add(messageWingow);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(300, 200);
		mainWindow.setTitle("Information Client");
		mainWindow.setVisible(true);

		mainWindow.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (client != null && client.isAlive()) {
					client.interrupt();
				}
				System.exit(0);
			}
		});
	}

	/**
	 * Getter method for messageWingow.
	 * 
	 * @return the messageWingow the window where all the messages are.
	 */
	public JTextArea getMessageWingow() {
		return messageWingow;
	}

	/**
	 * Setter method for messageWingow.
	 * 
	 * @param messageWingow
	 *            the messageWingow to set
	 */
	public void setMessageWingow(JTextArea messageWingow) {
		this.messageWingow = messageWingow;
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		new InformationClientGUI();
	}
}
