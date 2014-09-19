package com.sirma.itt.javacourse.desingPatterns.task7.calculator.commands;

/**
 * Builder for Commands.
 * 
 * @author Simeon Iliev
 */
public class CommandBuilder {

	private static CommandBuilder instance;

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
	 * Creates a new {@link AddCommand}.
	 * 
	 * @return the new {@link AddCommand}.
	 */
	public Command createAddCommand() {
		return new AddCommand();
	}

	/**
	 * Creates a new {@link DivideCommand}
	 * 
	 * @return new {@link DivideCommand}
	 */
	public Command createDivideCommand() {
		return new DivideCommand();
	}

	/**
	 * Creates a new {@link MultiplyCommand}
	 * 
	 * @return new {@link MultiplyCommand}
	 */
	public Command createMultiplyCommand() {
		return new MultiplyCommand();
	}

	/**
	 * Creates a new {@link OddCommand}
	 * 
	 * @return new {@link OddCommand}
	 */
	public Command createOddCommand() {
		return new OddCommand();
	}

	/**
	 * Creates a new {@link SubtractCommand}
	 * 
	 * @return new {@link SubtractCommand}
	 */
	public Command createSubstractCommand() {
		return new SubtractCommand();
	}
}
