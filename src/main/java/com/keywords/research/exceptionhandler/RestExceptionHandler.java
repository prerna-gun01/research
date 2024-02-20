package com.keywords.research.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.keywords.research.exception.CustomException;
import com.keywords.research.pojo.ErrorResponseEntity;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

	private static final int PRECONDITION_FAILED = 412;

	  @ExceptionHandler(CustomException.class)
	  public ResponseEntity<ErrorResponseEntity>resourceNotFoundException(
			  CustomException ex, WebRequest request) {
	    ErrorResponseEntity message =
	        new ErrorResponseEntity(HttpStatus.PRECONDITION_FAILED.value(), ex.getMessage());

	    return new ResponseEntity<ErrorResponseEntity>(message, HttpStatus.PRECONDITION_FAILED);
	  }
}
