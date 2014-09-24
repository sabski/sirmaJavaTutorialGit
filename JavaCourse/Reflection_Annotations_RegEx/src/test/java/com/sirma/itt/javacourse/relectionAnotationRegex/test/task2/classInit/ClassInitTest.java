package com.sirma.itt.javacourse.relectionAnotationRegex.test.task2.classInit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.ExpectedException;

import com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit.ClassInit;

/**
 * @author Simeon Iliev
 */
public class ClassInitTest {

	private ClassInit init;
	private String result = "java.lang.CharSequence";
	private String classUnderTest = "java.lang.String";
	private String error = "dasdlf";
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	@Rule
	public ExpectedException exception = ExpectedException.none();

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
		try {
			temp = init.getClassHierhahyAndInterfaces(classUnderTest);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		assertTrue(temp instanceof String);
		log.clear();
	}

	/**
	 * Test if method throws specific exception.
	 */
	@Test
	public void getClassHierhahyAndInterfacesWithError() {
		try {
			init.getClassHierhahyAndInterfaces(error);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			assert true;
		} finally {
			log.clear();
		}
	}
}
