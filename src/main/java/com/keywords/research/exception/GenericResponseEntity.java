package com.keywords.research.exception;

import org.springframework.http.ResponseEntity;

import com.keywords.research.entity.Volume;

public class GenericResponseEntity {

	private Integer code;
	private String msg;

	private ResponseEntity<Volume> responseEntity;
	public GenericResponseEntity(ResponseEntity<Volume> responseEntity, String msg) {
		super();
		this.responseEntity = responseEntity;
		this.msg = msg;
	}
	public GenericResponseEntity(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ResponseEntity<Volume> getResponseEntity() {
		return responseEntity;
	}
	public void setResponseEntity(ResponseEntity<Volume> responseEntity) {
		this.responseEntity = responseEntity;
	}
}
