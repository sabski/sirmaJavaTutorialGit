package com.sirma.itt.javacourse.networkingAndGui.task2.downloadAgent;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

/**
 * This class represents the front interface of a download GUI application.
 * 
 * @author Simeon Iliev
 */
public class DownloadAgentGui extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger
			.getLogger(DownloadAgentGui.class);
	public static final String SAVE_LOCATION = System.getProperty("user.home")
			+ System.getProperty("file.separator") + "DownloadAgent";

	private JTextField urlAddreddField;
	private JTextField saveLocationTextField;

	private JButton downloadButton;
	private JButton downloadLocationButton;
	private JFileChooser downloadDirChoser;
	private JProgressBar progresBar;
	private JLabel urlLabel;
	private DownloadUITask task;

	public DownloadAgentGui() {
		setUp();
	}

	/**
	 * Sets up main window and panels for the window.
	 */
	private void setUp() {
		JFrame mainWindow = this;
		mainWindow.setSize(400, 300);
		mainWindow.setLayout(new GridLayout(4, 1));
		mainWindow.setTitle("Download Agent");
		mainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initFields();
		// Panel set up
		JPanel urlPanel = new JPanel(new FlowLayout());
		JPanel fileLocationPanel = new JPanel(new FlowLayout());
		JPanel progresBarPanel = new JPanel(new FlowLayout());
		JPanel downloadPanel = new JPanel(new FlowLayout());
		urlPanel.add(urlLabel);
		urlPanel.add(urlAddreddField);
		fileLocationPanel.add(saveLocationTextField);
		fileLocationPanel.add(downloadLocationButton);
		progresBarPanel.add(progresBar);
		downloadPanel.add(downloadButton);
		// Adding panels
		mainWindow.add(urlPanel);
		mainWindow.add(fileLocationPanel);
		mainWindow.add(progresBarPanel);
		mainWindow.add(downloadPanel);

		// No code after this line
		mainWindow.setVisible(true);
	}

	/**
	 * Initializes fields and creates action listeners for the buttons.
	 */
	private void initFields() {
		urlAddreddField = new JTextField();
		urlAddreddField.setPreferredSize(new Dimension(150, 20));
		saveLocationTextField = new JTextField(SAVE_LOCATION);
		saveLocationTextField.setEditable(false);

		progresBar = new JProgressBar();

		downloadButton = new JButton("Start download");
		downloadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.info(e.getActionCommand());
				LOGGER.info(urlAddreddField.getText());
				taskCreator();
			}
		});
		urlLabel = new JLabel("URL");

		downloadLocationButton = new JButton("Chose download location");
		downloadLocationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LOGGER.info(e.getActionCommand());
				JFrame frame = new JFrame("Hello");
				downloadDirChoser = new JFileChooser(SAVE_LOCATION);
				downloadDirChoser.setVisible(true);
				downloadDirChoser
						.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = downloadDirChoser.showOpenDialog(frame);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String selected = downloadDirChoser.getSelectedFile()
							.getAbsolutePath();
					LOGGER.info(selected);
					saveLocationTextField.setText(selected);
				} else {
					LOGGER.info("Canceled");
				}
			}
		});
	}

	/**
	 * Creates task that are to be executed.
	 */
	private void taskCreator() {
		task = new DownloadUITask(urlAddreddField.getText(),
				saveLocationTextField.getText(), progresBar);
		task.execute();
	}
}
