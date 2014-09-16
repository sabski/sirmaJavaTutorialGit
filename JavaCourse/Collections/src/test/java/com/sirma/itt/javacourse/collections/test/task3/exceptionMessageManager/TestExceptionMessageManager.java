package com.sirma.itt.javacourse.collections.test.task3.exceptionMessageManager;

import static org.junit.Assert.assertEquals;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager;

/**
 * JUnit test case for
 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager}
 * 
 * @author Simeon Iliev
 */
public class TestExceptionMessageManager {

	private ExceptionsMessageManager manager;

	/**
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		manager = new ExceptionsMessageManager();
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager#addExceptionMessage(java.lang.String)}
	 * .
	 * 
	 * @throws InvalidAttributesException
	 */
	@Test
	public void testAddExceptionMessage() throws InvalidAttributesException {
		String result = manager.addExceptionMessage(ExceptionsMessageManager.INVALID_CARD_NUMBER);
		assertEquals(ExceptionsMessageManager.INVALID_CARD_NUMBER
				+ ExceptionsMessageManager.SEPARATOR, result);

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager#addExceptionMessage(java.lang.String)}
	 * .
	 * 
	 * @throws InvalidAttributesException
	 */
	@Test(expected = InvalidAttributesException.class)
	public void testAddExceptionMessageInvalidArgument() throws InvalidAttributesException {
		manager.addExceptionMessage("alabala");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager#addExceptionMessageUsingCode(java.lang.String)}
	 * .
	 * 
	 * @throws InvalidAttributesException
	 */
	@Test
	public void testAddExceptionMessageUsingCode() throws InvalidAttributesException {
		String result = manager.addExceptionMessageUsingCode(ExceptionsMessageManager.FIRST);
		assertEquals(ExceptionsMessageManager.INVALID_CARD_NUMBER
				+ ExceptionsMessageManager.SEPARATOR, result);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager#addExceptionMessageUsingCode(java.lang.String)}
	 * .
	 * 
	 * @throws InvalidAttributesException
	 */
	@Test(expected = InvalidAttributesException.class)
	public void testAddExceptionMessageUsingCodeInvalidCode() throws InvalidAttributesException {
		manager.addExceptionMessageUsingCode("kon");
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager#getMesage()}
	 * .
	 * 
	 * @throws InvalidAttributesException
	 */
	@Test
	public void testGetMesage() throws InvalidAttributesException {
		manager.addExceptionMessage(ExceptionsMessageManager.INVALID_CARD_NUMBER);
		manager.addExceptionMessage(ExceptionsMessageManager.INVALID_EGN);
		manager.addExceptionMessage(ExceptionsMessageManager.INVALID_POSTAL_CODE);
		String result = manager.getMesage();
		assertEquals(ExceptionsMessageManager.INVALID_CARD_NUMBER
				+ ExceptionsMessageManager.SEPARATOR + ExceptionsMessageManager.INVALID_EGN
				+ ExceptionsMessageManager.SEPARATOR + ExceptionsMessageManager.INVALID_POSTAL_CODE
				+ ExceptionsMessageManager.SEPARATOR, result);

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager#getMesage()}
	 * .
	 */
	@Test
	public void testGetMesageNoMessages() {
		String result = manager.getMesage();
		assertEquals("", result);

	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager#getMesages(java.lang.String)}
	 * .
	 * 
	 * @throws InvalidAttributesException
	 */
	@Test
	public void testGetMesages() throws InvalidAttributesException {
		manager.addExceptionMessage(ExceptionsMessageManager.INVALID_CARD_NUMBER);
		manager.addExceptionMessage(ExceptionsMessageManager.INVALID_EGN);
		manager.addExceptionMessage(ExceptionsMessageManager.INVALID_POSTAL_CODE);
		String temp = manager.addExceptionMessage(ExceptionsMessageManager.INVALID_POSTAL_CODE);
		String result = ExceptionsMessageManager.getMesages(temp).toString();
		assertEquals("[" + ExceptionsMessageManager.INVALID_CARD_NUMBER + ", "
				+ ExceptionsMessageManager.INVALID_EGN + ", "
				+ ExceptionsMessageManager.INVALID_POSTAL_CODE + ", "
				+ ExceptionsMessageManager.INVALID_POSTAL_CODE + "]", result);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.collections.task3.exceptionsMessageManager.ExceptionsMessageManager#getMesage()}
	 * .
	 * 
	 * @throws InvalidAttributesException
	 */
	@Test(expected = InvalidAttributesException.class)
	public void testGetMesagesNoMessages() throws InvalidAttributesException {
		ExceptionsMessageManager.getMesages("");

	}
}
