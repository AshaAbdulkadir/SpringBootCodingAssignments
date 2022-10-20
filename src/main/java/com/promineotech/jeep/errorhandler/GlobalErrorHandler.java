package com.promineotech.jeep.errorhandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, Object> handleNoSuchElementException(
			NoSuchElementException e) {
		return createExceptionMessage(e);
		
	}

	private Map<String, Object> createExceptionMessage(NoSuchElementException e) {
		
		Map<String, Object> error = new HashMap<>();
		return error;
	}

}
