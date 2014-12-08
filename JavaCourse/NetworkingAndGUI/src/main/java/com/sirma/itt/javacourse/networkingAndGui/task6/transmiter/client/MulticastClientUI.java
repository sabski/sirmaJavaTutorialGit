package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * User interface for {@link MulticastClient}.
 * 
 * @author siliev
 * 
 */
public class MulticastClientUI extends JFrame {

	private static final long serialVersionUID = 4084729024170473482L;

	// private static Logger log = Logger.getLogger(MulticastClientUI.class);

	private JTextArea messageWingow;
	private JButton connectButton;

	private MulticastClient client;

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		new MulticastClientUI();
	}

	/**
	 * Constructor.
	 */
	public MulticastClientUI() {
		setUp();
	}

	/**
	 * Set up method.
	 */
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
		mainWindow.setVisible(true);
		mainWindow.setTitle("Multicast Client");
		client = new MulticastClient(this);
		mainWindow.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (client.isAlive()) {
					client.stopClient();
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
