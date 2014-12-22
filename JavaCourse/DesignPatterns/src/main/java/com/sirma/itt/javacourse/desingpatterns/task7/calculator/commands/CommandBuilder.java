package com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder for Commands.
 * 
 * @author Simeon Iliev
 */
public class CommandBuilder {

	private static CommandBuilder instance;

	private static final List<Command> commands = new ArrayList<Command>(6);
	static {
		commands.add(new AddCommand());
		commands.add(new DivideCommand());
		commands.add(new MultiplyCommand());
		commands.add(new OddCommand());
		commands.add(new SubtractCommand());
		commands.add(new EqualsCommand());
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
	 * Creates a specific command given a String
	 * 
	 * @param command
	 *            the String value of the command.
	 * @return the command that was given with the String or null if no command
	 *         has confirmed the command.
	 */
	public Command createCommand(String command) {
		for (Command commandFromList : commands) {
			if (commandFromList.isMyCommand(command)) {
				return commandFromList;
			}
		}
		return null;
	}
}
