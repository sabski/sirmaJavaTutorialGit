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
import com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.OperationListener;

/**
 * @author siliev
 * 
 */
public class TestOperationListener {

	private OperationListener listener;
	private JTextField textFiled;
	private Command command;
	private String firstNumber;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		textFiled = new JTextField("5+6");
		command = new AddCommand();
		firstNumber = "5";
		listener = new OperationListener(textFiled, command, firstNumber);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.OperationListener#actionPerformed(java.awt.event.ActionEvent)}
	 * .
	 */
	@Test
	public void testActionPerformed() {
		listener.actionPerformed(new ActionEvent(textFiled, 0, "+"));
		assertTrue(textFiled.getText().contains("11.0"));
	}

}
