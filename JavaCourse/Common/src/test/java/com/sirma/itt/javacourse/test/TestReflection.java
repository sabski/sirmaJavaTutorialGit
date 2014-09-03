package com.sirma.itt.javacourse.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.ReflectionUtil;

/**
 * @author simeon
 */
public class TestReflection {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
