/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task1.calculator;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.AddCommand;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;
import com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.ClearListener;

/**
 * @author siliev
 * 
 */
public class TestClearListener {

	private ClearListener listener;
	private JTextField textFiled;
	private String firstNumber;
	private Command command;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		textFiled = new JTextField("test+");
		firstNumber = "2";
		command = new AddCommand();
		listener = new ClearListener(textFiled, firstNumber, command);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.ClearListener#actionPerformed(java.awt.event.ActionEvent)}
	 * .
	 */
	@Test
	public void testActionPerformed() {
		listener.actionPerformed(new ActionEvent(textFiled, 0, "C"));
		assertTrue(textFiled.getText().equals("test"));
	}

}
