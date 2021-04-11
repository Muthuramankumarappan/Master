package com.ticketingSystem.track.work.exception;

import org.springframework.http.HttpStatus;

public class ExceptionMessage extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpStatus Status;
	
	String message;

	public ExceptionMessage() {
	}

	public ExceptionMessage(HttpStatus status, String message) {
		Status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return Status;
	}

	public void setStatus(HttpStatus status) {
		Status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
