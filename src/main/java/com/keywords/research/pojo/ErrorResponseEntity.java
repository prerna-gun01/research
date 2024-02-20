package com.keywords.research.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponseEntity extends ResponseEntity<Object>{

	public ErrorResponseEntity(int status, String message) {
		super(message, HttpStatus.valueOf(status));
	}
}
