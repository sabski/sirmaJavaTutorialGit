package com.sirma.itt.javacourse.test.intro.task7.randomGenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.intro.task7.randomGenerator.RandomStringGenerator;

/**
 * Unit test class for RandomStringGenarator.
 * 
 * @author simeon
 */
public class RandomGeneratorUnitTest {

	/**
	 * Test if the random generator produces a String with the given lenght.
	 */
	@Test
	public void test() {
		RandomStringGenerator generaotr = new RandomStringGenerator();
		assertEquals(6, generaotr.generateRandomString(6).length());

	}

}
