package com.sirma.itt.javacourse.test.objects.sumator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

import com.sirma.itt.javacourse.objects.sumator.Sumator;

/**
 * @author simeon
 */
public class ObjectSumatorTest {

	private Sumator sumator = new Sumator();

	/**
	 * Test method for {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(int, int)}.
	 */
	@Test
	public void testSumIntInt() {

		assertEquals(5, sumator.sum(3, 2));
	}

	/**
	 * Test method for {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(float, float)}.
	 */
	@Test
	public void testSumFloatFloat() {
		assertEquals(5f, sumator.sum(2f, 3f), 0.0005f);
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public void testSumStringString() {
		assertEquals("555", sumator.sum("320", "235"));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.math.BigInteger, java.math.BigInteger)}
	 * .
	 */
	@Test
	public void testSumBigIntegerBigInteger() {
		BigInteger a = BigInteger.valueOf(52222);
		BigInteger b = BigInteger.valueOf(489552);
		BigInteger result = BigInteger.valueOf(541774);
		assertEquals(result, sumator.sum(a, b));
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.objects.sumator.Sumator#sum(java.math.BigDecimal, java.math.BigDecimal)}
	 * .
	 */
	@Test
	public void testSumBigDecimalBigDecimal() {
		BigDecimal a = BigDecimal.valueOf(52222);
		BigDecimal b = BigDecimal.valueOf(489552);
		BigDecimal resulut = BigDecimal.valueOf(541774);
		assertEquals(resulut, sumator.sum(a, b));
	}

}
