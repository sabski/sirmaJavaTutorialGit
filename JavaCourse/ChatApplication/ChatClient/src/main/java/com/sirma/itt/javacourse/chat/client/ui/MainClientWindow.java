package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.threads.ClientThread;

/**
 * @author siliev
 * 
 */
public class MainClientWindow extends JFrame {

	private static final long serialVersionUID = 1826026493714885025L;
	private static Logger log = Logger.getLogger(MainClientWindow.class);
	private JTextArea messageWingow;
	private JButton connectButton;
	private ClientThread client;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainClientWindow();
	}

	public MainClientWindow() {
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
		mainWindow.setTitle("Chat Client");
		mainWindow.setVisible(true);
		// client = new ClientThread(this);
		client = new ClientThread();
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

}
