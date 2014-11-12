package com.sirma.itt.javacourse.relectionAnotationRegex.test.task5.emailValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sirma.itt.javacourse.StringUtil;

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
		assertTrue(StringUtil.validateStringWithRegex(StringUtil.REGEX_VALIDATOR_EMAIL_ADDRESS,
				"simeon@mail.com"));
	}

	/**
	 * Test email validation with invalid email.
	 */
	@Test
	public void testEmailValidathionWithFalseMail() {
		assertFalse(StringUtil.validateStringWithRegex(StringUtil.REGEX_VALIDATOR_EMAIL_ADDRESS,
				"asdasdasda.lda.cko"));
	}

}
