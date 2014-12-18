package com.sirma.itt.javacourse.desing_patterns.task7.calculator.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.AddCommand;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.Command;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.CommandBuilder;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.DivideCommand;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.MultiplyCommand;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.OddCommand;
import com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.SubtractCommand;

/**
 * @author Simeon Iliev
 */
public class TestCommandBuilder {
	private final CommandBuilder builder = CommandBuilder.getInstance();

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.CommandBuilder#createAddCommand()}
	 * .
	 */
	@Test
	public void testCreateAddCommand() {
		Command command = builder.createCommand("+");
		assertTrue(command instanceof AddCommand);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.CommandBuilder#createDivideCommand()}
	 * .
	 */
	@Test
	public void testCreateDivideCommand() {
		Command command = builder.createCommand("/");
		assertTrue(command instanceof DivideCommand);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.CommandBuilder#createMultiplyCommand()}
	 * .
	 */
	@Test
	public void testCreateMultiplyCommand() {
		Command command = builder.createCommand("*");
		assertTrue(command instanceof MultiplyCommand);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.CommandBuilder#createOddCommand()}
	 * .
	 */
	@Test
	public void testCreateOddCommand() {
		Command command = builder.createCommand("^");
		assertTrue(command instanceof OddCommand);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.desingpatterns.task7.calculator.commands.CommandBuilder#createSubstractCommand()}
	 * .
	 */
	@Test
	public void testCreateSubstractCommand() {
		Command command = builder.createCommand("-");
		assertTrue(command instanceof SubtractCommand);
	}

}
