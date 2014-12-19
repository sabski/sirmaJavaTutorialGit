package com.sirma.itt.javacourse.networkingAndGui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ServerUI extends JFrame {

	private static final long serialVersionUID = 5793108222047669135L;

	private JButton startButton;
	private JButton stopButton;
	private JTextArea messageArea;
	private AbstractServer server;

	/**
	 * @param server
	 *            the server associated with this UI.
	 */
	public ServerUI(AbstractServer server) {
		this.server = server;
		setUp();
	}

	/**
	 * Set up method for the interface initiates the values and set the setting
	 * for the window frame.
	 */
	private void setUp() {
		JFrame mainWindow = this;
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		messageArea = new JTextArea();
		mainWindow.setSize(300, 250);
		mainWindow.setLayout(new BorderLayout());

		messageArea.setEditable(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		createButtonListners();
		mainWindow.add(buttonPanel, BorderLayout.NORTH);
		mainWindow.add(messageArea);
		mainWindow.setTitle(server.getClass().getSimpleName());
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);

		mainWindow.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (server != null) {
					server.stopServer();
				}
				System.exit(0);
			}

		});
	}

	/**
	 * Method for setting up the buttons. Creating and adding there action
	 * listeners.
	 */
	private void createButtonListners() {
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				server.setTextArea(messageArea);
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

}
