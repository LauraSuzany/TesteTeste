package com.laura.backenddev.controller.exception;

public class StandardError {
	private Integer status;
	private long timeStamp;
	private String message;
	
	
	public StandardError() {
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


	public StandardError(Integer status, long timeStamp, String message) {
		super();
		this.status = status;
		this.timeStamp = timeStamp;
		this.message = message;
	}
	
	
	


	
	

}
