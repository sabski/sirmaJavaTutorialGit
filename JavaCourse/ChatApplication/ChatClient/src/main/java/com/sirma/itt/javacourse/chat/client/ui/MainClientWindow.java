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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sirma.itt.javacourse.chat.client.managers.UIControler;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.componnents.InputDialog;
import com.sirma.itt.javacourse.chat.common.utils.LANGUAGES;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;
import com.sirma.itt.javacourse.desingpatterns.task6.observer.Observable;
import com.sirma.itt.javacourse.desingpatterns.task6.observer.Observer;

/**
 * The main window frame of the Chat client application. Also this class servers
 * as the entry point of the client application.
 * 
 * @author siliev
 * 
 */
public class MainClientWindow extends JFrame implements Observer {

	private static final long serialVersionUID = 1826026493714885025L;
	private JButton connectButton;
	private JButton disconnectButton;
	private ClientThread client;
	private TextArea textArea;
	private ChatsPanel chatPanel;
	private JList<String> userList;
	private JScrollPane scroll;

	private DefaultListModel<String> users;
	private UIControler controler;

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		new MainClientWindow();
	}

	/**
	 * Constructor.
	 */
	public MainClientWindow() {
		controler = UIControler.getInstance();
		setUp();
	}

	/**
	 * Set up method.
	 */
	private void setUp() {
		LanguageController.setLanguage(LANGUAGES.BG.toString());
		JFrame mainWindow = this;
		connectButton = new JButton(LanguageController.getWord("connect"));
		disconnectButton = new JButton(LanguageController.getWord("disconnect"));
		chatPanel = new ChatsPanel();
		textArea = new TextArea(connectButton, disconnectButton, this);
		users = new DefaultListModel<>();
		userList = new JList<String>(users);
		mainWindow.setLayout(new BorderLayout());
		userList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		userList.setLayoutOrientation(JList.VERTICAL);
		userList.setMinimumSize(new Dimension(100, 200));
		scroll = new JScrollPane(userList);
		JPanel userListPanel = new JPanel(new BorderLayout());
		userListPanel.add(scroll, BorderLayout.CENTER);
		mainWindow.add(userListPanel, BorderLayout.WEST);
		mainWindow.add(textArea, BorderLayout.SOUTH);
		mainWindow.add(chatPanel, BorderLayout.CENTER);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(800, 600);
		mainWindow.setTitle(LanguageController.getWord("titleclient"));
		mainWindow.setVisible(true);
		mainWindow.setLocationRelativeTo(null);
		mainWindow.setResizable(true);
		mainWindow.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				client = controler.getThread();
				if (client != null && client.isAlive()) {
					client.interrupt();
				}
				System.exit(0);
			}
		});
		setUpListeners();
		controler.registerMainWindow(this);
		controler.registerChatPanel(chatPanel);
	}

	private void setUpListeners() {
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InputDialog input = new InputDialog(textArea, controler);
				input.displayDialog();

			}
		});

		disconnectButton.setEnabled(false);
		disconnectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client = controler.getThread();
				if (client != null && client.isAlive()) {
					client.interrupt();
					chatPanel.resetChats();
					textArea.toogleText();
				}
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
	public void update(Observable observable) {
		if (controler.getClientInfo().getUserName() != null) {
			MainClientWindow.this.setTitle(LanguageController
					.getWord("titleclient")
					+ " "
					+ controler.getClientInfo().getUserName());

		} else {
			MainClientWindow.this.setTitle(LanguageController
					.getWord("titleclient"));
		}
		connectButton.setText(LanguageController.getWord("connect"));
		disconnectButton.setText(LanguageController.getWord("disconnect"));
		invalidate();
	}
}
