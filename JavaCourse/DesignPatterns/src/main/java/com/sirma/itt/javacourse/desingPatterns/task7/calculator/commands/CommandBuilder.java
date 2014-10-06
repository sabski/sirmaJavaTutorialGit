package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder for Commands.
 * 
 * @author Simeon Iliev
 */
public class CommandBuilder {

	private static CommandBuilder instance;

	private static final List<Command> commands = new ArrayList<Command>(5);
	static {
		commands.add(new AddCommand());
		commands.add(new DivideCommand());
		commands.add(new MultiplyCommand());
		commands.add(new OddCommand());
		commands.add(new SubtractCommand());
	}

	/**
	 * Singleton type constructor
	 */
	private CommandBuilder() {
	}

	/**
	 * Getter for class instance;
	 * 
	 * @return the single instance of the class.
	 */
	public static CommandBuilder getInstance() {
		if (instance == null) {
			instance = new CommandBuilder();
		}
		return instance;
	}

	/**
	 * Creates a specifick command given a String
	 * 
	 * @param command
	 *            the String value of the command.
	 * @return the command that was given with the String.
	 */
	public Command createCommand(String command) {
		for (Command com : commands) {
			if (com.isMyCommand(command)) {
				return com;
			}
		}
		return null;
	}
}
