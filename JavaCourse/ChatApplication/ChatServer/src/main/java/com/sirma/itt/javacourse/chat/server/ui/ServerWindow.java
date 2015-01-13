/**
 * 
 */
package com.sirma.itt.javacourse.chat.server.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chat.common.utils.LanguageController;
import com.sirma.itt.javacourse.chat.server.threads.MainServerThread;

/**
 * The main server window.
 * 
 * @author siliev
 * 
 */
public class ServerWindow extends JFrame {

	private static final long serialVersionUID = -401486980443255042L;
	private JButton startButton;
	private JButton stopButton;
	private JButton languageButton;
	private JTextField portTextField;
	private JTextArea messageArea;
	private MainServerThread server;

	/**
	 * Constructor.
	 */
	public ServerWindow() {
		setUp();
	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {

		new ServerWindow();

	}

	/**
	 * Set up method for the interface initiates the values and set the setting
	 * for the window frame.
	 */
	private void setUp() {
		// Start language setup.
		LanguageController.loadCurrentLanguage();
		LanguageController.setLanguage("BG");
		// TODO Add internatiolization preoperties.
		JFrame mainWindow = this;
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		languageButton = new JButton("EN/BG");
		portTextField = new JTextField("7000");
		messageArea = new JTextArea();
		mainWindow.setSize(300, 250);
		mainWindow.setLayout(new BorderLayout());

		messageArea.setEditable(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(portTextField);
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(languageButton);
		createButtonListners();
		mainWindow.add(buttonPanel, BorderLayout.NORTH);
		mainWindow.add(messageArea);
		mainWindow.setTitle("Chat Server");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);

		mainWindow.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (server != null) {
					server.interrupt();
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
				server = new MainServerThread(messageArea);
				server.start();
			}
		});

		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (server != null) {
					server.stopServer();
				}
			}
		});
	}

}
