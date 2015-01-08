/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task1.calculator;

import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.AddCommand;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.EqualsCommand;
import com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.NumberButtonLister;

/**
 * @author siliev
 * 
 */
public class TestNumberButtonListener {

	private NumberButtonLister listener;
	private Command command;
	private JTextField textFiled;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		textFiled = new JTextField();
		command = new AddCommand();
		listener = new NumberButtonLister(command, textFiled);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.NumberButtonLister#actionPerformed(java.awt.event.ActionEvent)}
	 * .
	 */
	@Test
	public void testActionPerformed() {
		listener.actionPerformed(new ActionEvent(textFiled, 0, "4"));
		assertTrue(textFiled.getText().contains("4"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.NumberButtonLister#actionPerformed(java.awt.event.ActionEvent)}
	 * .
	 */
	@Test
	public void testActionPerformedWithEqualsCommand() {
		command = new EqualsCommand();
		listener = new NumberButtonLister(command, textFiled);
		listener.actionPerformed(new ActionEvent(textFiled, 0, "4"));
		assertTrue(textFiled.getText().contains("4"));
	}

}
