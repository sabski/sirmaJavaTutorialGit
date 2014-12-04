/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task6.transmiter.server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author siliev
 * 
 */
public class MulticastServerUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1804980056427035663L;
	//private static Logger log = Logger.getLogger(MulticastServerUI.class);
	private JButton startButton;
	private JButton stopButton;
	private JTextArea messageArea;
	private MulticastServer server;

	/**
	 * Set up method for the interface initiates the values and set the setting
	 * for the window frame.
	 */
	private void setUp() {
		// TODO Have a nice day;
		JFrame mainWindow = this;
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		messageArea = new JTextArea();
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

		mainWindow.addWindowListener(new WindowAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				server.stopServer();
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
				server = new MulticastServer(messageArea);
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
	 * 
	 */
	public MulticastServerUI() {
		setUp();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MulticastServerUI();
	}

}
