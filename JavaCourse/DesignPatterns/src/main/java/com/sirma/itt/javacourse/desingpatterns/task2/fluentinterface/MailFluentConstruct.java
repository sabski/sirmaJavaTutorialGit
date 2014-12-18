package com.sirma.itt.javacourse.desingpatterns.task2.fluentinterface;

import java.io.File;

/**
 * Fluent Builder for {@link Mail}
 * 
 * @author Simeon Iliev
 */
public class MailFluentConstruct {

	private Mail mail;

	/**
	 * Creates a new {@link Mail} object
	 * 
	 * @param from
	 *            The person that is sending the mail.
	 * @param to
	 *            The receiver of the mail.
	 * @return the constructed {@link Mail} object
	 */
	public MailFluentConstruct createNewMailFromTo(String from, String to) {
		mail = new Mail(from, to);
		return this;
	}

	/**
	 * The subject of the mail.
	 * 
	 * @param subject
	 *            The subject of the mail.
	 * @return an instance of this interface so that other methods may be invoked.
	 */
	public MailFluentConstruct subjectIS(String subject) {
		mail.setSubject(subject);
		return this;
	}

	/**
	 * Sets the contents of the mail.
	 * 
	 * @param content
	 *            The content of the mail.
	 * @return an instance of this interface so that other methods may be invoked.
	 */
	public MailFluentConstruct writeContent(String content) {
		mail.setContent(content);
		return this;
	}

	/**
	 * Adds the CC list that will be used on the mail.
	 * 
	 * @param copies
	 *            Copies that have to be send to other users
	 * @return an instance of this interface so that other methods may be invoked.
	 */
	public MailFluentConstruct sendCCto(String copies) {
		mail.setCC(copies);
		return this;
	}

	/**
	 * Attaches a given file to the mail object.
	 * 
	 * @param attachment
	 *            The file that is to be attached to the mail object.
	 * @return an instance of this interface so that other methods may be invoked.
	 */
	public MailFluentConstruct attachFile(File attachment) {
		mail.getAttachments().add(attachment);
		return this;
	}

	/**
	 * Return the instance of the mail object.
	 * 
	 * @return the mail object that is to be send.
	 */
	public Mail send() {
		return mail;
	}

}
