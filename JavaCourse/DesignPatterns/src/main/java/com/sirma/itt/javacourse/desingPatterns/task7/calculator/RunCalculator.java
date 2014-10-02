package com.sirma.itt.javacourse.desingPatterns.task7.calculator;

import org.apache.log4j.Logger;

import com.sirma.itt.javacourse.IOUtils;
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
		IOUtils.printConsoleMessage("Calculator operations\n +,- ,*,/,^,= (Exits program) ");
		IOUtils.printConsoleMessage("Input number");

		while (true) {
			if (firstNumber == 0d) {
				firstNumber = IOUtils.readDouble();
			} else {
				log.info(firstNumber + "");
			}

			IOUtils.printConsoleMessage("Input operation you want to execute : ");
			String operation = IOUtils.readValidatedLine("[\\*-/\\+/\\^=]");
			Command command = builder.createCommand(operation);
			if (command == null) {
				break;
			}
			IOUtils.printConsoleMessage("Input number");
			firstNumber = command.execute(firstNumber, IOUtils.readDouble());
			calculator.takeCommand(command);
		}

	}

}
