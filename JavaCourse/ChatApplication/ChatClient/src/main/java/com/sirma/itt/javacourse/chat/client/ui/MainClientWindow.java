package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
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
	private JButton connectButton;
	private ClientThread client;
	private TextArea textArea;
	private ChatsPanel chatPanel;
	// private JList<ChatUser> userList;
	private JList userList;
	private DefaultListModel<String> users;

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
		chatPanel = new ChatsPanel();
		textArea = new TextArea(connectButton);
		users = new DefaultListModel<>();
		userList = new JList(users);
		client = new ClientThread();
		textArea.setClient(client);
		mainWindow.setLayout(new BorderLayout());
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				client.start();
				client.sendMessage(new Message(ClientMessageInterpretor.inputUserName(), 0,
						TYPE.CONNECT, null));
				// client.sendMessage(new Message("", 0,
				// Message.TYPE.CONNECT.toString()));
			}
		});

		// Test user List values
		users.addElement("Test");
		users.addElement("Test1");
		users.addElement("Test2");
		// End
		userList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		userList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		userList.setPreferredSize(new Dimension(80, 400));
		mainWindow.add(userList, BorderLayout.WEST);
		mainWindow.add(textArea, BorderLayout.SOUTH);
		mainWindow.add(chatPanel, BorderLayout.CENTER);
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
				if (client != null && client.isAlive()) {
					client.interrupt();
				}
				System.exit(0);
			}

		});
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
