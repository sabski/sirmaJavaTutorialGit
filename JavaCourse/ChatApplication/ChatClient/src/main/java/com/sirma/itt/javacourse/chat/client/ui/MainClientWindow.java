package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.common.utils.LanguageControler;
import com.sirma.itt.javacourse.chat.common.utils.LanguageControler.LANGUGES;
import com.sirma.itt.javacourse.chat.common.utils.UIColegue;

/**
 * The main window frame of the Chat client application. Also this class servers
 * as the entry point of the client application.
 * 
 * @author siliev
 * 
 */
public class MainClientWindow extends JFrame implements UIColegue {

	private static final long serialVersionUID = 1826026493714885025L;
	private static Logger log = Logger.getLogger(MainClientWindow.class);
	private JTextArea messageWingow;
	private JButton connectButton;
	private ClientThread client;

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		new MainClientWindow();
	}

	/**
	 * Constructor.
	 */
	public MainClientWindow() {
		setUp();
	}

	/**
	 * Set up method.
	 */
	private void setUp() {
		LanguageControler.setLanguage(LANGUGES.BG.toString());
		JFrame mainWindow = this;
		connectButton = new JButton(LanguageControler.getWord("connect"));
		messageWingow = new JTextArea();
		messageWingow.setEditable(false);

		mainWindow.setLayout(new BorderLayout());
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client = new ClientThread();
				client.start();
				client.sendMessage(inputUserName());
			}
		});

		mainWindow.add(connectButton, BorderLayout.NORTH);
		mainWindow.add(messageWingow);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(600, 400);
		mainWindow.setTitle("Chat Client");
		mainWindow.setVisible(true);
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

	public String inputUserName() {
		String name = null;
		name = JOptionPane.showInputDialog(LanguageControler
				.getWord("inputUsername"));
		return name;
	}

	@Override
	public void sendUIEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respondToEvent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerComponent() {
		// TODO Auto-generated method stub
		
	}
}
