package com.sirma.itt.javacourse.chat.client.ui.componnents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sirma.itt.javacourse.chat.client.managers.UIControler;
import com.sirma.itt.javacourse.chat.client.threads.ClientThread;
import com.sirma.itt.javacourse.chat.client.ui.TextArea;
import com.sirma.itt.javacourse.chat.common.utils.LanguageController;

public class InputDialog {

	private String username;
	private String address;
	private int port;
	private TextArea textArea;
	private UIControler controler;

	public InputDialog(TextArea textArea, UIControler controler) {
		this.textArea = textArea;
		this.controler = controler;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void displayDialog() {
		final JTextField addressField = new JTextField("localhost");
		final JTextField portField = new JTextField("7000");
		final JTextField usernameField = new JTextField("user");
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Cancel");

		JPanel myPanel = new JPanel();
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		myPanel.add(new JLabel(LanguageController.getWord("address")));
		myPanel.add(addressField);
		myPanel.add(new JLabel(LanguageController.getWord("port")));
		myPanel.add(portField);
		myPanel.add(new JLabel(LanguageController.getWord("inputUsername")));
		myPanel.add(usernameField);

		
		JPanel buttonPannel= new JPanel();
		buttonPannel.add(okButton);
		buttonPannel.add(cancelButton);
		
		myPanel.add(buttonPannel);
		final JFrame frame = new JFrame();
		frame.add(myPanel);
		frame.setSize(500, 200);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (1 <= addressField.getText().length()
						&& 1 <= portField.getText().length()
						&& 1 <= usernameField.getText().length()) {
					address = addressField.getText();
					username = usernameField.getText();
					port = Integer.parseInt(portField.getText());

					ClientThread client = new ClientThread(username, address,
							port, textArea);
					controler.setThread(client);
					client.start();
					textArea.toogleText();
					frame.dispose();
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
}
