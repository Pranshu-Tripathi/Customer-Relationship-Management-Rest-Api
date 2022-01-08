package com.pranshu.crm.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleNotFoundException(CustomerNotFoundException exc)
	{
		
		// create Customer Error Response object
		
		CustomerErrorResponse error = new CustomerErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		ResponseEntity<CustomerErrorResponse> responseEntity = new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleBadRequestException(Exception exc)
	{
		// create customer error response message
		
		CustomerErrorResponse error = new CustomerErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		ResponseEntity<CustomerErrorResponse> responseEntity = new ResponseEntity<CustomerErrorResponse>(error,HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
	
}
