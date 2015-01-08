/**
 * 
 */
package com.sirma.itt.javacourse.networkingAndGui.task1.calculator;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.ClearAllListener;

/**
 * @author siliev
 * 
 */
public class TestClearAllListener {

	private ClearAllListener listener;
	private JTextField textFiled;
	private String firstNumber;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		textFiled = new JTextField();
		firstNumber = "12";
		listener = new ClearAllListener(textFiled, firstNumber);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui.listeners.ClearAllListener#actionPerformed(java.awt.event.ActionEvent)}
	 * .
	 */
	@Test
	public void testActionPerformed() {
		listener.actionPerformed(new ActionEvent(textFiled, 0, "CE"));
		assertTrue(textFiled.getText().equals(""));
	}

}
