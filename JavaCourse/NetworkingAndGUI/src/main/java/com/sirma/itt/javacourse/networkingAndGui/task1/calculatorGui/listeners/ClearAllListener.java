package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * The idea of this action listener is to clear all the text from a specific
 * text filed and to a string value.
 * 
 * @author siliev
 * 
 */
public class ClearAllListener implements ActionListener {
	private JTextField textFiled;
	@SuppressWarnings("unused")
	private String firstNumber;

	/**
	 * Constructor.
	 * 
	 * @param textFiled
	 *            the text field that we want to apply the action to.
	 * @param firstNumber
	 *            the number we want to reset.
	 */
	public ClearAllListener(JTextField textFiled, String firstNumber) {
		this.textFiled = textFiled;
		this.firstNumber = firstNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textFiled.setText("");
		firstNumber = null;
	}

}
