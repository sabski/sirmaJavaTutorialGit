/**
 * 
 */
package com.sirma.itt.javacourse.chat.client.ui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.MessageMemento;
import com.sirma.itt.javacourse.MessageOriginator;
import com.sirma.itt.javacourse.chat.common.utils.UIColegue;

/**
 * @author siliev
 * 
 */
public class TextArea extends JFrame implements UIColegue {

	private static final long serialVersionUID = 8138842498862853077L;
	private static Logger log = Logger.getLogger(TextArea.class);

	private MessageOriginator originator;
	private List<MessageMemento> mementos;
	private int index;
	private JButton sendButton;
	private JTextField messageField;

	/**
	 * 
	 */
	public TextArea() {
		setUP();
	}

	/**
	 * 
	 */
	private void setUP() {
		listenersSetUp();
	}

	/**
	 * Sets up the lister for the button and the action commands for the key
	 * strokes.
	 */
	private void listenersSetUp() {
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage(messageField.getText());
			}

		});

		Action keyDown = new AbstractAction() {

			private static final long serialVersionUID = 11L;

			@Override
			public void actionPerformed(ActionEvent e) {
				index--;
				if (index > -1) {
					messageField.setText(originator.restoreFromMemento(mementos
							.get(index)));
				} else {
					index = -1;
				}
			}
		};

		Action keyUp = new AbstractAction() {

			private static final long serialVersionUID = 10L;

			@Override
			public void actionPerformed(ActionEvent e) {
				index++;
				if (mementos.size() > index) {
					messageField.setText(originator.restoreFromMemento(mementos
							.get(index)));
				} else {
					index = mementos.size() - 1;
				}
			}
		};

		messageField.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),
				"keyDown");
		messageField.getInputMap().put(KeyStroke.getKeyStroke("UP"), "keyUp");

		messageField.getActionMap().put("keyDown", keyDown);
		messageField.getActionMap().put("keyUp", keyUp);

	}

	private void sendMessage(String text) {

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
