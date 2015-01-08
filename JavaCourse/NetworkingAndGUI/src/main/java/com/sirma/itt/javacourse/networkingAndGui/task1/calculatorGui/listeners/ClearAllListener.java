/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * @author siliev
 * 
 */
public class ClearAllListener implements ActionListener {
	private JTextField textFiled;
	@SuppressWarnings("unused")
	private String firstNumber;

	/**
	 * @param textFiled
	 * @param firstNumber
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
