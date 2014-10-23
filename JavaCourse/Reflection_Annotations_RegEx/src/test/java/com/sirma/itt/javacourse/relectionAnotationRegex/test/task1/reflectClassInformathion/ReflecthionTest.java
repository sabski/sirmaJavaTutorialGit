package com.sirma.itt.javacourse.relectionAnotationRegex.test.task1.reflectClassInformathion;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ClassInformer;

/**
 * Unit test for testing the reflection of objects.
 * 
 * @author simeon
 */
public class ReflecthionTest {

	private static Logger log = Logger.getLogger(ReflecthionTest.class);
	private ClassInformer classInformer;
	private ReflectionClass reflectionOBject;
	private final String result = "ReflectionClass.print()";

	/**
	 * Sets up test variables for testing.
	 * 
	 * @throws Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		classInformer = new ClassInformer();
		reflectionOBject = new ReflectionClass();
	}

	/**
	 * Test the reflection of a specific class from the console output.
	 */
	@Test
	public void testReflect() {
		String temp = null;
		try {
			temp = classInformer.getObjectFieldsAndMethods(reflectionOBject);
		} catch (SecurityException | IllegalArgumentException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(temp.contains(result));
	}

	/**
	 * Test when we want to reflect a null object.
	 */
	@Test(expected = NullPointerException.class)
	public void testReflectNullObject() {
		Object obj = null;
		String result = null;
		try {
			result = classInformer.getObjectFieldsAndMethods(obj);
		} catch (IllegalArgumentException | SecurityException e) {
			log.error(e.getMessage(), e);
		}
		assertTrue(result.contains("Object is null"));
	}
}
