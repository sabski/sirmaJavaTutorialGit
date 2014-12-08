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
 * @author Simeon Iliev
 */
public class InformationClientGUI extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -6264959974014685722L;
	// private static Logger log = Logger.getLogger(InformationClientGUI.class);

	private JTextArea messageWingow;
	private JButton connectButton;
	private InformationClient client;

	/**
	 * Constructor for GUI class.
	 */
	public InformationClientGUI() {
		setUp();
	}

	private void setUp() {
		JFrame mainWindow = this;
		connectButton = new JButton("Connect");
		messageWingow = new JTextArea();
		messageWingow.setEditable(false);

		mainWindow.setLayout(new BorderLayout());
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client.start();
			}
		});

		mainWindow.add(connectButton, BorderLayout.NORTH);
		mainWindow.add(messageWingow);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(300, 200);
		mainWindow.setTitle("Information Client");
		mainWindow.setVisible(true);
		client = new InformationClient(this);
		mainWindow.addWindowListener(new WindowAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				if (client.isAlive()) {
					client.interrupt();
				}
				System.exit(0);
			}

		});
	}

	/**
	 * Getter method for messageWingow.
	 * 
	 * @return the messageWingow
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
	 * Main method
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		new InformationClientGUI();
	}

}
