package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.client;

import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

public class ClientGui extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 3497964934272245742L;
	private static Logger log = Logger.getLogger(ClientGui.class);

	private JTextField messageWingow;
	private JLabel messageLabel;
	private ClientSoket client;

	/**
	 * @throws HeadlessException
	 */
	public ClientGui() throws HeadlessException {
		setUp();
		startConnection();
	}

	private void setUp() {
		JFrame mainWindow = this;
		messageWingow = new JTextField();
		messageLabel = new JLabel("Actions");
		messageWingow.setEditable(false);
		mainWindow.setLayout(new GridLayout(2, 1));
		mainWindow.add(messageLabel);
		mainWindow.add(messageWingow);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(300, 200);
		mainWindow.setVisible(true);
	}

	private void startConnection() {
		client = new ClientSoket();

		messageWingow.setText(client.connect());
		messageWingow.setText(messageWingow.getText() + "\n" + client.message());
		messageWingow.setText(messageWingow.getText() + "\n" + client.disconnect());
	}
}
