package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;

/**
 * This {@link ActionListener} is used to set text to a specified JTextField.
 * 
 * @author siliev
 * 
 */
public class NumberButtonLister implements ActionListener {

	private static final Logger LOGGER = Logger
			.getLogger(NumberButtonLister.class);
	private Command command;
	private JTextField textFiled;

	/**
	 * Constructor.
	 * 
	 * @param command
	 *            the command that we are listening to.
	 * @param textFiled
	 *            the text field we want to add.
	 */
	public NumberButtonLister(Command command, JTextField textFiled) {
		super();
		this.command = command;
		this.textFiled = textFiled;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (command != null && command.isMyCommand("=")) {
			textFiled.setText(e.getActionCommand());
			textFiled.validate();
			command = null;
		} else {
			textFiled.setText(textFiled.getText() + e.getActionCommand());
			textFiled.validate();
		}
		LOGGER.info(e.getActionCommand() + " : " + textFiled.getText());
	}
}