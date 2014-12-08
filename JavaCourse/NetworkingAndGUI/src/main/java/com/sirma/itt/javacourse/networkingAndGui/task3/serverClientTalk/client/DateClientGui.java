package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server.DateServer;

/**
 * User interface for the {@link DateServer} client {@link DateClient}.
 * 
 * @author Simeon Iliev
 */
public class DateClientGui extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 3497964934272245742L;
	// private static Logger log = Logger.getLogger(DateClientGui.class);

	private JTextArea messageWingow;
	private JLabel messageLabel;
	private DateClient client;

	/**
	 * Start the window frame and opens the connection to the server.
	 */
	public DateClientGui() {
		setUp();
		startConnection();
	}

	/**
	 * Sets up the window elements.
	 */
	private void setUp() {
		JFrame mainWindow = this;
		messageWingow = new JTextArea();
		messageLabel = new JLabel("Actions");
		messageWingow.setEditable(false);
		JPanel labelPanel = new JPanel();
		labelPanel.setPreferredSize(new Dimension(300, 30));
		labelPanel.add(messageLabel);
		mainWindow.setLayout(new BorderLayout());
		mainWindow.setTitle("Date Client");
		mainWindow.add(labelPanel, BorderLayout.NORTH);
		mainWindow.add(messageWingow);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(300, 200);
		mainWindow.setVisible(true);
	}

	/**
	 * Opens the connection to the server and extracts the message data and
	 * closes the connection.
	 */
	private void startConnection() {
		client = new DateClient();
		messageWingow.setText(client.connect());
		messageWingow.setText(messageWingow.getText() + "\n"
				+ client.getMessage());
		messageWingow.setText(messageWingow.getText() + "\n"
				+ client.disconnect());
	}
}
