package com.sirma.itt.javacourse.relectionAnotationRegex.test.task1.reflectClassInformathion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import com.sirma.itt.javacourse.IOUtils;
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
	private String result = "com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass"
			+ "public int intValue = 14"
			+ "protected boolean lie = false"
			+ "float pie = 3.14"
			+ "private class java.lang.String string = Lendo galendo"
			+ "public int com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.getIntValue()"
			+ "public void com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.setIntValue(int)"
			+ "public boolean com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.isLie()"
			+ "public void com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.setLie(boolean)"
			+ "public float com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.getPie()"
			+ "public void com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.setPie(float)"
			+ "public void com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.setString(java.lang.String)"
			+ "public java.lang.String com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.getString()"
			+ "public void com.sirma.itt.javacourse.reflectionAnotationRegex.task1.reflectClassInformation.ReflectionClass.print()";

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

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
		/*
		 * try { reflector.reflect(reflectionOBject); } catch (IllegalArgumentException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (SecurityException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IllegalAccessException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch (NoSuchFieldException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); } String temp =
		 * log.getLog().replaceAll(System.getProperty("line.separator"), ""); assertEquals(result,
		 * temp); log.clear();
		 */
	}

	/**
	 * Test when we want to reflect a null object.
	 */
	@Test
	public void testReflectNullObject() {
		Object obj = null;
		try {
			reflector.reflect(obj);

		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Object is null", log.getLog().replaceAll("\n", ""));
		IOUtils.printConsoleMessage(log.getLog());
		log.clear();
	}
}
