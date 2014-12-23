package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.CommandBuilder;

/**
 * @author Simeon Iliev
 */
public class CalculatorGui extends JFrame {

	private static Logger log = Logger.getLogger(CalculatorGui.class);
	/**
	 * Comment for serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	// Operation buttons
	private JButton plusButton;
	private JButton minusButton;
	private JButton divideButton;
	private JButton multiplyButton;
	private JButton clearAllButton;
	private JButton clearLastSymbollButton;
	private JButton equalsButton;
	private JButton decimalDotButton;
	// Number buttons
	private JButton numberOneButton;
	private JButton numberTwoButton;
	private JButton numberThreeButton;
	private JButton numberFourButton;
	private JButton numberFiveButton;
	private JButton numberSixButton;
	private JButton numberSevenButton;
	private JButton numberEightButton;
	private JButton numberNineButton;
	private JButton numberZeroButton;

	private JTextField textFiled;

	private ActionListener numberButtonListener;
	private ActionListener operationListener;
	private final CommandBuilder builder;
	private String firstNumber;
	private String secondNumber;
	private Command command;

	/**
	 * Constructor for the calculator UI.
	 */
	public CalculatorGui() {
		starBuildingGUI();
		builder = CommandBuilder.getInstance();
	}

	/**
	 * 
	 */
	private void starBuildingGUI() {
		// Get current frame reference.
		JFrame frame = this;

		// Set base frame values.
		frame.setBounds(250, 250, 300, 300);

		// Do more cool stuff here...
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setTitle("Calculator");

		// Top frame
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		setUpTopPanel(topPanel);
		frame.add(topPanel, BorderLayout.NORTH);
		// Button frame
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(6, 3));
		setupButtons(buttonPanel);
		buttonPanel.validate();
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.pack();
		// NO MORE CODE BELLOW THIS LINE...
		frame.setVisible(true);
	}

	/**
	 * Creates the top half off the panel.
	 * 
	 * @param topPanel
	 *            the panel where the numbers and result will appear.
	 */
	private void setUpTopPanel(JPanel topPanel) {
		textFiled = new JTextField();
		textFiled.setEditable(false);
		textFiled.setText("");
		textFiled.setPreferredSize(new Dimension(300, 20));
		topPanel.add(textFiled);

	}

	/**
	 * Creates the buttons for the calculator and sets their actions listeners
	 * also orders them in an orderly fashion.
	 * 
	 * @param panel
	 *            the panel to add the buttons to.
	 */
	private void setupButtons(JPanel panel) {
		plusButton = new JButton("+");
		minusButton = new JButton("-");
		divideButton = new JButton("/");
		multiplyButton = new JButton("*");
		equalsButton = new JButton("=");
		clearAllButton = new JButton("CE");
		clearLastSymbollButton = new JButton("C");
		decimalDotButton = new JButton(".");

		// Creating number buttons;
		numberOneButton = new JButton("1");
		numberTwoButton = new JButton("2");
		numberThreeButton = new JButton("3");
		numberFourButton = new JButton("4");
		numberFiveButton = new JButton("5");
		numberSixButton = new JButton("6");
		numberSevenButton = new JButton("7");
		numberEightButton = new JButton("8");
		numberNineButton = new JButton("9");
		numberZeroButton = new JButton("0");

		numberButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (command != null && command.isMyCommand("=")) {
					textFiled.setText(e.getActionCommand());
					textFiled.validate();
					command = null;
				} else {
					textFiled.setText(textFiled.getText()
							+ e.getActionCommand());
					textFiled.validate();

				}
				log.info(e.getActionCommand() + " : " + textFiled.getText());
			}
		};

		numberZeroButton.addActionListener(numberButtonListener);
		numberOneButton.addActionListener(numberButtonListener);
		numberTwoButton.addActionListener(numberButtonListener);
		numberThreeButton.addActionListener(numberButtonListener);
		numberFourButton.addActionListener(numberButtonListener);
		numberFiveButton.addActionListener(numberButtonListener);
		numberSixButton.addActionListener(numberButtonListener);
		numberSevenButton.addActionListener(numberButtonListener);
		numberEightButton.addActionListener(numberButtonListener);
		numberNineButton.addActionListener(numberButtonListener);

		operationListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				log.info(e.getActionCommand());
				if (firstNumber == null || command == null) {
					firstNumber = textFiled.getText();
					command = builder.createCommand(e.getActionCommand());
					textFiled.setText(textFiled.getText()
							+ e.getActionCommand());
				} else {
					int a = (firstNumber + " ").length();
					int b = textFiled.getText().length();
					log.info("a = " + a + " b = " + b + " first = "
							+ firstNumber);
					secondNumber = textFiled.getText().substring(a, b);

					firstNumber = command.execute(Double.valueOf(firstNumber),
							Double.valueOf(secondNumber)) + "";
					log.info("Result = " + firstNumber);
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
		};

		equalsButton.addActionListener(operationListener);
		plusButton.addActionListener(operationListener);
		minusButton.addActionListener(operationListener);
		divideButton.addActionListener(operationListener);
		multiplyButton.addActionListener(operationListener);
		decimalDotButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFiled.setText(textFiled.getText() + ".");
			}
		});

		// Clear Buttons
		clearAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textFiled.setText("");
				firstNumber = null;
			}
		});

		clearLastSymbollButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String temp = textFiled.getText().substring(
						textFiled.getText().length() - 1);
				log.info("Clear " + temp);
				if (temp.matches("\\+|-|\\*|/")) {
					command = null;
					firstNumber = null;
					log.info("Matches " + firstNumber);
				}
				textFiled.setText(textFiled.getText().substring(0,
						textFiled.getText().length() - 1));
			}
		});

		// Buttons added to the panel.
		panel.add(clearAllButton);
		panel.add(divideButton);
		panel.add(plusButton);
		panel.add(minusButton);
		panel.add(multiplyButton);
		panel.add(equalsButton);
		panel.add(numberSevenButton);
		panel.add(numberEightButton);
		panel.add(numberNineButton);
		panel.add(numberFourButton);
		panel.add(numberFiveButton);
		panel.add(numberSixButton);
		panel.add(numberOneButton);
		panel.add(numberTwoButton);
		panel.add(numberThreeButton);
		panel.add(numberZeroButton);
		panel.add(decimalDotButton);
		panel.add(clearLastSymbollButton);
	}
}
