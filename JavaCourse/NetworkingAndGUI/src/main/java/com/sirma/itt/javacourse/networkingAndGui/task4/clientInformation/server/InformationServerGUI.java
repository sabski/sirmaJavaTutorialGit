package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * UI for the Information Server.
 * 
 * @author Simeon Iliev
 */
public class InformationServerGUI extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 2732996645737413793L;

	private static Logger log = Logger.getLogger(InformationServerGUI.class);
	private JButton startButton;
	private JButton stopButton;
	private JTextArea messageArea;
	private InformationServer server;

	/**
	 * Constructor that visualizes the frame.
	 */
	public InformationServerGUI() {
		setUp();
	}

	/**
	 * Set up method for the interface initiates the values and set the setting for the window
	 * frame.
	 */
	private void setUp() {
		// TODO Have a nice day;
		JFrame mainWindow = this;
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		messageArea = new JTextArea();
		server = new InformationServer(messageArea);
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

	}

	/**
	 * Method for setting up the buttons. Creating and adding there action listeners.
	 */
	private void createButtonListners() {
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
	 * Main method.
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		new InformationServerGUI();
	}

}
