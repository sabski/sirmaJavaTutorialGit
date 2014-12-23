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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sirma.itt.javacourse.chat.client.managers.ClientMessageInterpretor;
import com.sirma.itt.javacourse.chat.client.managers.UIControler;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.common.Message;
import com.sirma.itt.javacourse.chat.common.Message.TYPE;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController.LANGUGES;
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
	private JButton connectButton;
	private ClientThread client;
	private TextArea textArea;
	private ChatsPanel chatPanel;
	// private JList<ChatUser> userList;
	private JList<String> userList;

	private DefaultListModel<String> users;
	private UIControler controler;

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
		controler = UIControler.getInstance();
		setUp();
		registerComponent();
	}

	/**
	 * Set up method.
	 */
	private void setUp() {
		LanguageController.setLanguage(LANGUGES.BG.toString());
		JFrame mainWindow = this;
		connectButton = new JButton(LanguageController.getWord("connect"));
		chatPanel = new ChatsPanel();
		textArea = new TextArea(connectButton);
		users = new DefaultListModel<>();
		userList = new JList<String>(users);
		mainWindow.setLayout(new BorderLayout());
		userList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		userList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		userList.setPreferredSize(new Dimension(80, 400));
		client = controler.getThread();
		mainWindow.add(userList, BorderLayout.WEST);
		mainWindow.add(textArea, BorderLayout.SOUTH);
		mainWindow.add(chatPanel, BorderLayout.CENTER);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(600, 400);
		mainWindow.setTitle("Chat Client");
		mainWindow.setVisible(true);
		mainWindow.setLocationRelativeTo(null);
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
		setUpListeners();
	}

	private void setUpListeners() {
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client.start();
				client.sendMessage(new Message(ClientMessageInterpretor
						.inputUserName(), 0, TYPE.CONNECT, null));
			}
		});

		userList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				controler.createChatRoom(userList.getSelectedValuesList());
			}
		});
	}

	/**
	 * @return the users
	 */
	public DefaultListModel<String> getUsers() {
		return users;
	}

	/**
	 * @return the userList
	 */
	public JList<String> getUserList() {
		return userList;
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
		controler.registerMainWindow(this);
	}
}
