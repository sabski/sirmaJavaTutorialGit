package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer;

/**
 * User interface for the {@link DateServer} client {@link DateClient}.
 * 
 * @author Simeon Iliev
 */
public class DateClientGui extends JFrame {

	private static final long serialVersionUID = 3497964934272245742L;

	private JTextArea messageWingow;
	private DateClient client;
	private JButton connectButton;

	/**
	 * Start the window frame and opens the connection to the server.
	 */
	public DateClientGui() {
		setUp();
	}

	/**
	 * Sets up the window elements.
	 */
	private void setUp() {
		JFrame mainWindow = this;
		messageWingow = new JTextArea();
		connectButton = new JButton("Connect");
		messageWingow.setEditable(false);
		JPanel labelPanel = new JPanel();
		labelPanel.setPreferredSize(new Dimension(300, 30));
		labelPanel.add(connectButton);
		mainWindow.setLayout(new BorderLayout());
		mainWindow.setTitle("Date Client");
		mainWindow.add(labelPanel, BorderLayout.NORTH);
		mainWindow.add(messageWingow);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(300, 200);
		mainWindow.setVisible(true);
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startConnection();
			}
		});
	}

	/**
	 * Opens the connection to the server and extracts the message data and
	 * closes the connection.
	 */
	private void startConnection() {
		client = new DateClient(messageWingow);
		client.start();
	}

}
