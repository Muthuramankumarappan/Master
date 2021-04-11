package com.ticketingSystem.track.work.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TicetExceptions {

	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> exception(ExceptionMessage msg){
		return new ResponseEntity<ExceptionMessage>(msg, msg.getStatus());
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionMessage> exception(Exception msg){
		ExceptionMessage exc = new ExceptionMessage(HttpStatus.NO_CONTENT,msg.getMessage());
		return new ResponseEntity<ExceptionMessage>(exc, exc.getStatus());
		
	}
}
