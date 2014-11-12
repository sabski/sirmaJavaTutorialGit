package com.sirma.itt.javacourse.desingPatterns.task7.calculator;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.InputUtils;
import com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands.Command;
import com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands.CommandBuilder;

/**
 * Calculator runner class.
 * 
 * @author Simeon Iliev
 */
public class RunCalculator {

	private static Logger log = Logger.getLogger(RunCalculator.class.getName());

	/**
	 * Main method for the program.
	 * 
	 * @param args
	 *            arguments for the main method.
	 */
	public static void main(String[] args) {
		double firstNumber = 0d;
		Calculator calculator = new Calculator();
		CommandBuilder builder = CommandBuilder.getInstance();
		InputUtils.printConsoleMessage("Calculator operations\n +,- ,*,/,^,= (Exits program) ");
		InputUtils.printConsoleMessage("Input number");

		while (true) {
			if (firstNumber == 0d) {
				firstNumber = InputUtils.readDouble();
			} else {
				log.info(firstNumber + "");
			}

			InputUtils.printConsoleMessage("Input operation you want to execute : ");
			String operation = InputUtils.readValidatedLine("[\\*-/\\+/\\^=]");
			Command command = builder.createCommand(operation);
			if (command == null) {
				break;
			}
			InputUtils.printConsoleMessage("Input number");
			firstNumber = command.execute(firstNumber, InputUtils.readDouble());
			calculator.takeCommand(command);
		}

	}

}
