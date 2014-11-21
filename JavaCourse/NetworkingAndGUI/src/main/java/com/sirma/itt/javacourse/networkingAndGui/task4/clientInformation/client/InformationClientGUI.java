package com.sirma.itt.javacourse.networkingAndGui.task4.clientInformation.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

/**
 * @author Simeon Iliev
 */
public class InformationClientGUI extends JFrame {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = -6264959974014685722L;
	private static Logger log = Logger.getLogger(InformationClientGUI.class);

	private JTextArea messageWingow;
	private JButton connectButton;
	private InformationClient client;

	/**
	 *
	 */
	public InformationClientGUI() {
		setUp();
	}

	private void setUp() {
		JFrame mainWindow = this;
		connectButton = new JButton("Connect");
		messageWingow = new JTextArea();
		messageWingow.setEditable(false);
		client = new InformationClient(messageWingow);
		mainWindow.setLayout(new GridLayout(2, 1));
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client.start();
			}
		});

		mainWindow.add(connectButton);
		mainWindow.add(messageWingow);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(300, 200);
		mainWindow.setVisible(true);
	}

	//
}
