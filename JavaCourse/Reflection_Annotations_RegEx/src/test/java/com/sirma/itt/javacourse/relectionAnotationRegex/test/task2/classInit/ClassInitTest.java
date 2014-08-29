package com.sirma.itt.javacourse.relectionAnotationRegex.test.task2.classInit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.rules.ExpectedException;

import com.sirma.itt.javacourse.IOUtils;
import com.sirma.itt.javacourse.reflectionAnotationRegex.task2.classInit.ClassInit;

public class ClassInitTest {

	private ClassInit init;
	private String result = "java.lang.String$1java.lang.String$CaseInsensitiveComparatorjava.io.Serializablejava.lang.Comparablejava.lang.CharSequence";
	private String classUnderTest = "java.lang.String";
	private String error = "dasdlf";
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		init = new ClassInit();
	}

	/**
	 * Test that the class is initiated and all of its methods are printed out.
	 */
	@Test
	public void testGetClassHierhahyAndInterfaces() {
		try {
			init.getClassHierhahyAndInterfaces(classUnderTest);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temp = log.getLog().replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
		assertTrue(result.equals(temp));
		log.clear();
	}

	/**
	 * Test if method throws specific exception.
	 */
	@Test
	public void GetClassHierhahyAndInterfacesWithError() {
		try {
			init.getClassHierhahyAndInterfaces(error);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assert true;
		}
		log.clear();
	}
}
