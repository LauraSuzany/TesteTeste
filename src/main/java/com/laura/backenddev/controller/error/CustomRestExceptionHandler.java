//package com.laura.backenddev.controller.error;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//
//import org.junit.Test;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import io.swagger.models.Response;
//@ControllerAdvice
//public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler  {
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			  MethodArgumentNotValidException ex, 
//			  org.springframework.http.HttpHeaders headers, 
//			  HttpStatus status, 
//			  WebRequest request)
//	
//	
//	{
//	    List<String> errors = new ArrayList<String>();
//	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
//	        errors.add(error.getField() + ": " + error.getDefaultMessage());
//	    }
//	    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
//	        errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
//	    }
//	    ApiError apiError = 
//	    	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
//	    return handleExceptionInternal(
//	      ex, apiError, headers, apiError.getStatus(), request);
//}
//	@Override
//	protected ResponseEntity<Object> handleMissingServletRequestParameter(
//	  MissingServletRequestParameterException ex, HttpHeaders headers, 
//	  HttpStatus status, WebRequest request) {
//	    String error = ex.getParameterName() + " parameter is missing";
//	    
//	    ApiError apiError = 
//	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
//	    return new ResponseEntity<Object>(
//	      apiError, new HttpHeaders(), apiError.getStatus());
//	}
//	@ExceptionHandler({ ConstraintViolationException.class })
//	public ResponseEntity<Object> handleConstraintViolation(
//	  ConstraintViolationException ex, WebRequest request) {
//	    List<String> errors = new ArrayList<String>();
//	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
//	        errors.add(violation.getRootBeanClass().getName() + " " + 
//	          violation.getPropertyPath() + ": " + violation.getMessage());
//	    }
//	    ApiError apiError = 
//	    	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
//	    	    return new ResponseEntity<Object>(
//	    	      apiError, new HttpHeaders(), apiError.getStatus());
//	    	}
//	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
//	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
//	  MethodArgumentTypeMismatchException ex, WebRequest request) {
//	    String error = 
//	      ex.getName() + " should be of type " + ex.getRequiredType().getName();
//
//	    ApiError apiError = 
//	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
//	    return new ResponseEntity<Object>(
//	      apiError, new HttpHeaders(), apiError.getStatus());
//	}
//	@Test
//	public void whenMethodArgumentMismatch_thenBadRequest() {
//		Response response = ResponseEntity<User>();
//		ApiError error = response.as(ApiError.class);
//
//	    assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
//	    assertEquals(1, error.getErrors().size());
//	    assertTrue(error.getErrors().get(0).contains("should be of type"));
//	
//	
//}
//
//}
