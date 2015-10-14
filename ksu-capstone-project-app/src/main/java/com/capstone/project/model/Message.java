package com.capstone.project.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer _messageId;
	private String _from;
	private String _to;
	private String _subject;
	private String _messageText;
	private Boolean _messageReadFlag;
	private LocalDate _createdDate;
	
	public Message(Integer messageId, String from, String to, String subject, String messageText,
			Boolean messageReadFlag, LocalDate createdDate) {
		super();
		_messageId = messageId;
		_from = from;
		_to = to;
		_subject = subject;
		_messageText = messageText;
		_messageReadFlag = messageReadFlag;
		_createdDate = createdDate;
	}

	public Integer getMessageId() {
		return _messageId;
	}

	public void setMessageId(Integer messageId) {
		_messageId = messageId;
	}

	public String getFrom() {
		return _from;
	}

	public void setFrom(String from) {
		_from = from;
	}

	public String getTo() {
		return _to;
	}

	public void setTo(String to) {
		_to = to;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getMessageText() {
		return _messageText;
	}

	public void setMessageText(String messageText) {
		_messageText = messageText;
	}

	public Boolean getMessageReadFlag() {
		return _messageReadFlag;
	}

	public void setMessageReadFlag(Boolean messageReadFlag) {
		_messageReadFlag = messageReadFlag;
	}

	public LocalDate getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		_createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Message [_messageId=" + _messageId + ", _from=" + _from + ", _to=" + _to + ", _subject=" + _subject
				+ ", _messageText=" + _messageText + ", _messageReadFlag=" + _messageReadFlag + ", _createdDate="
				+ _createdDate + "]";
	}

}
