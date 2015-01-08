/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;

/**
 * @author siliev
 * 
 */
public class NumberButtonLister implements ActionListener {

	private static final Logger LOGGER = Logger
			.getLogger(NumberButtonLister.class);
	private Command command;
	private JTextField textFiled;

	/**
	 * @param command
	 * @param textFiled
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
