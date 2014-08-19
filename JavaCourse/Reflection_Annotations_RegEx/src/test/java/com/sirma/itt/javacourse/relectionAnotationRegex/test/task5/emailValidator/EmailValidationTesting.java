package com.sirma.itt.javacourse.relectionAnotationRegex.test.task5.emailValidator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.Utils;

/**
 * Test class for email validation regex.
 * 
 * @author simeon
 */
public class EmailValidationTesting {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test with valid email address.
	 */
	@Test
	public void testEmailValidathion() {
		assertTrue(Utils.validateStringWithRegex(Utils.REGEX_VALIDATOR_EMAIL_ADDRESS,
				"simeon@mail.com"));
	}

	@Test
	public void testEmailValidathionWithFalseMail(){
		assertFalse(Utils.validateStringWithRegex(Utils.REGEX_VALIDATOR_EMAIL_ADDRESS, "asdasdasda.lda.cko"));
	}
	
}
