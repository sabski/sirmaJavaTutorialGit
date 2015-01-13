package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;

/**
 * This listener removes the last entered character in a text field.
 * 
 * @author siliev
 * 
 */
public class ClearListener implements ActionListener {

	private JTextField textFiled;
	@SuppressWarnings("unused")
	private String firstNumber;
	@SuppressWarnings("unused")
	private Command command;

	/**
	 * Constructor.
	 * 
	 * @param textFiled
	 *            the text field we want to modify.
	 * @param firstNumber
	 *            the string we want to reset.
	 * @param command
	 *            the command we want to reset.
	 */
	public ClearListener(JTextField textFiled, String firstNumber,
			Command command) {
		this.textFiled = textFiled;
		this.firstNumber = firstNumber;
		this.command = command;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp = textFiled.getText().substring(
				textFiled.getText().length() - 1);
		if (temp.matches("\\+|-|\\*|/")) {
			command = null;
			firstNumber = null;
		}
		textFiled.setText(textFiled.getText().substring(0,
				textFiled.getText().length() - 1));
	}
}
