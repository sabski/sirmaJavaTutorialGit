package com.sirma.itt.javacourse.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.sirma.itt.javacourse.ReflectionUtil;

/**
 * JUnit test class for {@link com.sirma.itt.javacourse.ReflectionUtil}
 * 
 * @author Simeon Iliev
 */
public class TestReflection {

	private Logger log = Logger.getLogger(TestReflection.class.getName());

	private String testOne = "aaa";
	private String testTwo = null;
	private Integer intTest = 2;

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.ReflectionUtil#compareObjects(java.lang.Object, java.lang.Object)}
	 * .
	 */
	@Test
	public void testCompareObjects() {
		try {
			assertTrue(ReflectionUtil.compareObjects(testOne, testOne));
		} catch (SecurityException e) {
			log.error("Security error", e);
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument ", e);
		} catch (NoSuchFieldException e) {
			log.error("No such field", e);
		} catch (IllegalAccessException e) {
			log.error("Illegal access", e);
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.ReflectionUtil#compareObjects(java.lang.Object, java.lang.Object)}
	 * .
	 */
	@Test
	public void testCompareObjectsWithNull() {
		try {
			assertFalse(ReflectionUtil.compareObjects(testOne, testTwo));
		} catch (SecurityException e) {
			log.error("Security error", e);
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument ", e);
		} catch (NoSuchFieldException e) {
			log.error("No such field", e);
		} catch (IllegalAccessException e) {
			log.error("Illegal access", e);
		}
	}

	/**
	 * Test method for
	 * {@link com.sirma.itt.javacourse.ReflectionUtil#compareObjects(java.lang.Object, java.lang.Object)}
	 * .
	 */
	@Test
	public void testCompareObjectsWithDifferentClasses() {
		try {
			assertFalse(ReflectionUtil.compareObjects(testOne, intTest));
		} catch (SecurityException e) {
			log.error("Security error", e);
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument ", e);
		} catch (NoSuchFieldException e) {
			log.error("No such field", e);
		} catch (IllegalAccessException e) {
			log.error("Illegal access", e);
		}
	}
}
