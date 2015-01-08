package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;

public class ClearListener implements ActionListener {

	private JTextField textFiled;
	@SuppressWarnings("unused")
	private String firstNumber;
	@SuppressWarnings("unused")
	private Command command;

	/**
	 * @param textFiled
	 * @param firstNumber
	 * @param command
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
