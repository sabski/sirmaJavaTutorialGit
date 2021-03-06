package com.sirma.itt.javacourse.chat.common;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -103156352094886756L;

	private String content;
	private Long chatRoomId;
	private MessageType messageType;
	private String author;

	/**
	 * @return the messageType
	 */
	public MessageType getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType
	 *            the messageType to set
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the chatRoomId
	 */
	public Long getChatRoomId() {
		return chatRoomId;
	}

	/**
	 * @param chatRoomId
	 *            the chatRoomId to set
	 */
	public void setChatRoomId(Long chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param content
	 * @param chatRoomId
	 * @param messageType
	 * @param author
	 */
	public Message(String content, long chatRoomId, MessageType messageType,
			String author) {
		this.content = content;
		this.chatRoomId = chatRoomId;
		this.messageType = messageType;
		this.author = author;
	}

	@Override
	public String toString() {
		return messageType.toString() + " " + author + " " + chatRoomId + " "
				+ content;
	}
}
