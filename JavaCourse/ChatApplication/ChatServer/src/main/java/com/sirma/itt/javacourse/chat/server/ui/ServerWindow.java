package com.sirma.itt.javacourse.chat.server.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.StringUtil;
import com.sirma.itt.javacourse.chat.common.utils.LANGUAGES;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;
import com.sirma.itt.javacourse.chat.server.controler.ServerController;
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
	private JScrollPane scroll;
	private MainServerThread server;
	private ServerController controler;

	/**
	 * Constructor.
	 * 
	 * @param serverControler
	 */
	public ServerWindow(ServerController serverControler) {
		this.controler = serverControler;
		setUp();
	}

	/**
	 * Set up method for the interface initiates the values and set the setting
	 * for the window frame.
	 */
	private void setUp() {
		try {
			LanguageController.loadCurrentLanguage();
		} catch (MalformedURLException e1) {

		}
		JFrame mainWindow = this;
		startButton = new JButton();
		stopButton = new JButton();
		languageButton = new JButton();
		startButton.setText(LanguageController.getWord("start"));
		stopButton.setText(LanguageController.getWord("stop"));
		languageButton.setText(LanguageController.getWord("enbg"));
		portTextField = new JTextField("7000");
		messageArea = new JTextArea();
		mainWindow.setSize(300, 250);
		mainWindow.setLayout(new BorderLayout());
		scroll = new JScrollPane(messageArea);
		messageArea.setEditable(false);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(portTextField);
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(languageButton);
		createButtonListners();
		mainWindow.add(buttonPanel, BorderLayout.NORTH);
		mainWindow.add(scroll);
		mainWindow.setTitle(LanguageController.getWord("titleserver"));
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
				if (portTextField.getText().isEmpty()
						&& StringUtil.validateStringWithRegex(
								StringUtil.REGEX_VALIDATOR_NUMBERS_ONLY,
								portTextField.getText())) {
					JOptionPane.showMessageDialog(null,
							LanguageController.getWord("servernoport"),
							LanguageController.getWord("error"),
							JOptionPane.ERROR_MESSAGE);
				} else {
					controler.startServer(Integer.parseInt(portTextField
							.getText()));
				}
			}
		});

		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controler.stopServer();
			}
		});

		languageButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (LanguageController.getCurrentLanguage().equals(
						LANGUAGES.BG.toString())) {
					LanguageController.setLanguage(LANGUAGES.EN.toString());
				} else {
					LanguageController.setLanguage(LANGUAGES.BG.toString());
				}
				try {
					LanguageController.loadCurrentLanguage();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				startButton.setText(LanguageController.getWord("start"));
				stopButton.setText(LanguageController.getWord("stop"));
				languageButton.setText(LanguageController.getWord("enbg"));
				ServerWindow.this.setTitle(LanguageController
						.getWord("titleserver"));
			}
		});
	}

	/**
	 * Displays an information message on to the server UI.
	 * 
	 * @param message
	 *            the message we want to display on to the UI.
	 */
	public void displayMessage(String message) {
		messageArea.setText(messageArea.getText() + message + "\n");
	}
}
