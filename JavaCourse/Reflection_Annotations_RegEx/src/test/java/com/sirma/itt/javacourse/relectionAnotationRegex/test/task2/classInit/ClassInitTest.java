package com.sirma.itt.javacourse.relectionAnotationRegex.test.task2.classInit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit.ClassInit;

/**
 * @author Simeon Iliev
 */
public class ClassInitTest {

	private ClassInit init;
	private final String result = "java.lang.CharSequence";
	private final String classUnderTest = "java.lang.String";
	private final String error = "dasdlf";

	/**
	 * Set up method.
	 * 
	 * @throws Exception
	 *             Something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		init = new ClassInit();
	}

	/**
	 * Test that the class is initiated and all of its methods are printed out.
	 */
	@Test
	public void testGetClassHierhahyAndInterfaces() {
		Object temp = null;
		temp = init.getClassHierhahyAndInterfaces(classUnderTest);
		assertTrue(temp instanceof String);
	}

	/**
	 * Test if method throws specific exception.
	 */
	@Test(expected = NullPointerException.class)
	public void getClassHierhahyAndInterfacesWithError() {
		init.getClassHierhahyAndInterfaces(error);

	}
}
