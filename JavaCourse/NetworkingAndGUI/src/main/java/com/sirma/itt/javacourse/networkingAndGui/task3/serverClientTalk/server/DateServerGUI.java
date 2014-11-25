package com.sirma.itt.javacourse.networkingAndGui.task3.serverClientTalk.server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.desing_patterns.task6.observer.Observable;
import com.sirma.itt.javacourse.desing_patterns.task6.observer.Observer;

/**
 * User interface for the {@link DateServer} class.
 * 
 * @author Simeon Iliev
 */
public class DateServerGUI extends JFrame implements Observer {

	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 2519152785419071442L;

	private static Logger log = Logger.getLogger(DateServerGUI.class);
	private JButton startButton;
	private JButton stopButton;
	private JTextArea messageArea;
	private DateServer server;

	/**
	 * Constructor that visualizes the frame.
	 */
	public DateServerGUI() {
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
		server = new DateServer();
		server.attachObserver(this);
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
		// TODO Press all the buttons...

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				server.startServer();
				new Thread(new Runnable() {

					@Override
					public void run() {
						server.acceptConnection();
					}
				}).start();
			}
		});

		stopButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				server.stopServer();
			}
		});
	}

	@Override
	public void update(Observable observable) {
		messageArea.setText(messageArea.getText() + "\n" + server.getLastMessage());
	}

}
