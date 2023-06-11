package com.app.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //= @ControllerAdvice + @ResponceBody
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException
	(MethodArgumentNotValidException e){
		System.out.println("in method arhument invalid"+e);
		List<FieldError> fieldErrors = e.getFieldErrors();
		Map<String,String> map = fieldErrors.stream()
				.collect(Collectors.toMap(null, null))
		return null;
	}

}
