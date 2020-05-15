package com.vinod.app.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vinod.app.exception.EmployeeNotFoundException;
import com.vinod.app.model.ExceptionResponse;

@ControllerAdvice
public class GloblaExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleEmployeNotFoundException(final EmployeeNotFoundException exc,
			final HttpServletRequest request) {
		
		ExceptionResponse errorResponse = new ExceptionResponse();
		
		errorResponse.setErrorMessage(exc.getMessage());
		errorResponse.setErrorStatusCode("NOT_FOUND");
		
		return errorResponse;
		
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleEmployeNotFoundException(final Exception exc,
			final HttpServletRequest request) {
		
		ExceptionResponse errorResponse = new ExceptionResponse();
		
		errorResponse.setErrorMessage("Exception thrown from main exception class");
		errorResponse.setErrorStatusCode("NOT_FOUND");
		
		return errorResponse;
		
	}
	
}
