package com.laura.backenddev.controller.exception;

import javassist.tools.web.BadHttpRequest;

public class badReques extends BadHttpRequest{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	private long timeStamp;
	private String message;

		
	public badReques() {
		super();
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public badReques(Integer status, long timeStamp, String message) {
		super();
		this.status = status;
		this.timeStamp = timeStamp;
		this.message = "inválidos ou incompletos";	
	
	}
	
}
