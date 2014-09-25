package com.sirma.itt.javacourse.relectionAnotationRegex.test.task1.reflectClassInformathion;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.Reflector;

/**
 * Unit test for testing the reflection of objects.
 * 
 * @author simeon
 */
public class ReflecthionTest {

	private Reflector reflector;
	private ReflectionClass reflectionOBject;
	private String result = "ReflectionClass.print()";

	/**
	 * Sets up test variables for testing.
	 * 
	 * @throws Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		reflector = new Reflector();
		reflectionOBject = new ReflectionClass();
	}

	/**
	 * Test the reflection of a specific class from the console output.
	 */
	@Test
	public void testReflect() {
		String temp = null;
		try {
			temp = reflector.reflect(reflectionOBject);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		assertTrue(temp.contains(result));
	}

	/**
	 * Test when we want to reflect a null object.
	 */
	@Test
	public void testReflectNullObject() {
		Object obj = null;
		String result = null;
		try {
			result = reflector.reflect(obj);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		assertTrue(result.contains("Object is null"));
	}
}
