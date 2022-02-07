package com.laura.backenddev.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.tools.web.BadHttpRequest;
@ControllerAdvice
public class badRequesHttp extends BadHttpRequest {
	@Autowired
	@ExceptionHandler(BadHttpRequest.class)
	public ResponseEntity<badReques> errorD (BadHttpRequest e, HttpServletRequest request){
		badReques erroBad = new  badReques(HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroBad);
	
	}
}



	

	
