package com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands;

public class EqualsCommand implements Command {

	private final static String EQUALS_COMMAND = "=";

	@Override
	public Double execute(Double firstNumber, Double secondNumber) {
		return null;
	}

	@Override
	public boolean isMyCommand(String command) {
		return command.equals(EQUALS_COMMAND);
	}

}
