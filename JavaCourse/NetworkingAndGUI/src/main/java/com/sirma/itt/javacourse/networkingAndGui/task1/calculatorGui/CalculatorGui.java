package com.sirma.itt.javacourse.networkingAndGui.task1.calculatorGui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

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

	/**
	 * 
	 */
	public CalculatorGui() {
		starBuildingGUI();
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
		frame.setLayout(new GridLayout(2, 1));
		frame.setTitle("Calculator");

		// Top frame
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		setUpTopPanel(topPanel);
		frame.add(topPanel);
		// Button frame
		JPanel buttonFrame = new JPanel();
		buttonFrame.setLayout(new GridLayout(4, 4));
		setupButtons(buttonFrame);
		frame.add(buttonFrame);

		// NO MORE CODE BELLOW THIS LINE...
		frame.setVisible(true);
	}

	private void setUpTopPanel(JPanel topPanel) {
		// TODO Something something something...
		textFiled = new JTextField();
		textFiled.setEditable(false);
		textFiled.setText("0");
		topPanel.add(textFiled);

	}

	private void setupButtons(JPanel panel) {
		// TODO set up Jenson Button...
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
				// TODO The other stuff besides printing the log.
				textFiled.setText(textFiled.getText() + e.getActionCommand());
				textFiled.validate();
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
		plusButton.addActionListener(numberButtonListener);
		minusButton.addActionListener(numberButtonListener);
		divideButton.addActionListener(numberButtonListener);
		multiplyButton.addActionListener(numberButtonListener);
		decimalDotButton.addActionListener(numberButtonListener);

		// TODO add missing action listeners... do not forget John Snow

		panel.add(clearAllButton);
		panel.add(clearLastSymbollButton);
		panel.add(decimalDotButton);
		panel.add(divideButton);
		panel.add(plusButton);
		panel.add(minusButton);
		panel.add(multiplyButton);
		panel.add(equalsButton);
		panel.add(numberNineButton);
		panel.add(numberEightButton);
		panel.add(numberSevenButton);
		panel.add(numberSixButton);
		panel.add(numberFiveButton);
		panel.add(numberFourButton);
		panel.add(numberThreeButton);
		panel.add(numberTwoButton);
		panel.add(numberOneButton);
		panel.add(numberZeroButton);

	}

}
