package com.sirma.itt.javacourse.desing_patterns.task2.fluent_interface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Mail object
 * 
 * @author Simeon Iliev
 */
public class Mail {

	private String from = null;
	private String to = null;
	private String subject;
	private String content;
	private String CC;
	private List<File> attachments;

	/**
	 * Getter method for from.
	 * 
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Setter method for from.
	 * 
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;

	}

	/**
	 * Getter method for to.
	 * 
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Setter method for to.
	 * 
	 * @param to
	 *            the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Getter method for subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Setter method for subject.
	 * 
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Getter method for content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Setter method for content.
	 * 
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Getter method for cC.
	 * 
	 * @return the cC
	 */
	public String getCC() {
		return CC;
	}

	/**
	 * Setter method for cC.
	 * 
	 * @param cC
	 *            the cC to set
	 */
	public void setCC(String cC) {
		CC = cC;
	}

	/**
	 * Getter method for attachments.
	 * 
	 * @return the attachments
	 */
	public List<File> getAttachments() {
		return attachments;
	}

	/**
	 * Setter method for attachments.
	 * 
	 * @param attachments
	 *            the attachments to set
	 */
	public void setAttacments(List<File> attachments) {
		this.attachments = attachments;
	}

	/**
	 * @param from
	 *            The person that is sending the mail
	 * @param to
	 *            The receiver of the mail.
	 */
	public Mail(String from, String to) {
		this.from = from;
		this.to = to;
		attachments = new ArrayList<File>();
	}
}
