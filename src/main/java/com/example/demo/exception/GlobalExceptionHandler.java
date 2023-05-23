package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public Map<String,String> validateInvalidInput(MethodArgumentNotValidException ex){
		
		Map<String,String> map = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach( e -> {
			String fieldName = e.getField();
			String errorMessage = e.getDefaultMessage();
			map.put(fieldName, errorMessage);
		});
		return map;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({HttpMessageNotReadableException.class})
	public Map<String,String> validateInvalidInput(HttpMessageNotReadableException ex){
		
		Map<String,String> map = new HashMap<>();
		map.put("Invalid Input", ex.getMessage());
		return map;
	}
	
	

}
