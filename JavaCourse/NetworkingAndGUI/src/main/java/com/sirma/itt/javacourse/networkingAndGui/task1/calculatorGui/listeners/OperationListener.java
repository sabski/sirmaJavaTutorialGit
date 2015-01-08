/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.CommandBuilder;

/**
 * @author siliev
 * 
 */
public class OperationListener implements ActionListener {

	private static final Logger LOGGER = Logger
			.getLogger(OperationListener.class);
	private final CommandBuilder builder;

	private JTextField textFiled;
	private Command command;
	private String firstNumber;
	private String secondNumber;

	/**
	 * @param textFiled
	 * @param command
	 * @param firstNumber
	 */
	public OperationListener(JTextField textFiled, Command command,
			String firstNumber) {
		builder = CommandBuilder.getInstance();
		this.textFiled = textFiled;
		this.command = command;
		this.firstNumber = firstNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		LOGGER.info(e.getActionCommand());
		if (firstNumber == null || command == null) {
			firstNumber = textFiled.getText();
			command = builder.createCommand(e.getActionCommand());
			textFiled.setText(textFiled.getText() + e.getActionCommand());
		} else {
			int a = (firstNumber + " ").length();
			int b = textFiled.getText().length();
			LOGGER.info("a = " + a + " b = " + b + " first = " + firstNumber);
			secondNumber = textFiled.getText().substring(a, b);

			firstNumber = command.execute(Double.valueOf(firstNumber),
					Double.valueOf(secondNumber))
					+ "";
			LOGGER.info("Result = " + firstNumber);
			command = builder.createCommand(e.getActionCommand());
			if (command.isMyCommand("=")) {
				textFiled.setText(firstNumber + "");
				firstNumber = null;
			} else {
				textFiled.setText(firstNumber + e.getActionCommand());
			}
		}
		textFiled.validate();
	}

}
