package com.demo.sre.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.sre.exception.DemoException;

@RestControllerAdvice("com.demo.sre.controller")
public class ExceptionHandlerController {

	
	@ExceptionHandler(DemoException.class)
	public ResponseEntity<ErrorInfo> demoExceptionHandler(DemoException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(exception.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.BAD_REQUEST);
	}
  @ExceptionHandler(Exception.class)
	public  ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage("Internal Server error");
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	
}
