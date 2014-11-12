package com.sirma.itt.javacourse.desingPatterns.task7.calculator;

import java.util.ArrayList;
import java.util.List;

import com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands.Command;

/**
 * Class calculator that accepts Commands and executes them.
 * 
 * @author Simeon Iliev
 */
public class Calculator {

	private final List<Command> listOfOperations = new ArrayList<Command>();

	public void takeCommand(Command command) {
		listOfOperations.add(command);
	}
}
