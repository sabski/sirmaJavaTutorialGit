package com.sirma.itt.javacourse.relectionAnotationRegex.test.task5.emailValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.IOUtils;

/**
 * Test class for email validation regex.
 * 
 * @author simeon
 */
public class EmailValidationTesting {

	/**
	 * Test with valid email address.
	 */
	@Test
	public void testEmailValidathion() {
		assertTrue(IOUtils.validateStringWithRegex(IOUtils.REGEX_VALIDATOR_EMAIL_ADDRESS,
				"simeon@mail.com"));
	}

	/**
	 * Test email validation with invalid email.
	 */
	@Test
	public void testEmailValidathionWithFalseMail() {
		assertFalse(IOUtils.validateStringWithRegex(IOUtils.REGEX_VALIDATOR_EMAIL_ADDRESS,
				"asdasdasda.lda.cko"));
	}

}
