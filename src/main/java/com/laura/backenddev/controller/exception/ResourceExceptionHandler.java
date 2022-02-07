	package com.laura.backenddev.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<StandardError> objectNotFound (Exception e, HttpServletRequest request){
		StandardError error = new  StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	
	}
}
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,  HttpHeaders headers, 
//	  HttpStatus status, 
//	  WebRequest request) { List<> errors = new ArrayList<String>();   for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//	        errors.add(error.getField() + ": " + error.getDefaultMessage());
//	    }
//	    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//	        errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//	    }
//	    
//	    ApiError apiError = 
//	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
//	    return handleExceptionInternal(
//	      ex, apiError, headers, apiError.getStatus(), request);
//	}
//}



