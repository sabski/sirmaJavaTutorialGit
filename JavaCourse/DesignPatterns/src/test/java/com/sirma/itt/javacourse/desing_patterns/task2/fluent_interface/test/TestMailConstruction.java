package com.sirma.itt.javacourse.desing_patterns.task2.fluent_interface.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.desing_patterns.task2.fluent_interface.Mail;
import com.sirma.itt.javacourse.desing_patterns.task2.fluent_interface.MailFluentConstruct;

/**
 * Test class for {@link Mail} and {@link MailFluentConstruct}
 * 
 * @author Simeon Iliev
 */
public class TestMailConstruction {

	private static final String SUBJECT = "Unit Testing";
	private static final String CONTENT = "How can i write better unit tests.";
	private static final String CCCOPY = "Boqn";
	private static final String TO = "hristo";
	private static final String FROM = "simeon";
	private final MailFluentConstruct mailWriter = new MailFluentConstruct();
	private Mail mail;

	/**
	 * Set  up method
	 * @throws java.lang.Exception
	 *             something went wrong
	 */
	@Before
	public void setUp() throws Exception {
		mail = mailWriter.createNewMailFromTo(FROM, TO).subjectIS(SUBJECT).sendCCto(CCCOPY)
				.writeContent(CONTENT).attachFile(null).send();
	}

	@Test
	public void testFrom() {
		assertEquals(FROM, mail.getFrom());
	}

	@Test
	public void testTO() {
		assertEquals(TO, mail.getTo());
	}

	@Test
	public void testCCcopy() {
		assertEquals(CCCOPY, mail.getCC());
	}

	@Test
	public void testContent() {
		assertEquals(CONTENT, mail.getContent());
	}

	@Test
	public void testFileList() {
		List<File> list = new ArrayList<File>();
		list.add(null);
		assertEquals(list, mail.getAttachments());
	}

}
