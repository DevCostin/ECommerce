package net.devcostin.code.infrastructure.rest;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler{
	
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Object> handleConflictInexistent() {
		return new ResponseEntity<>("Resource not found",HttpStatus.NOT_FOUND);
	}
}