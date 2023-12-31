package com.backend.clinicaodontologica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExeceptionHandler {
	@ExceptionHandler({ResourceNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> manejarResourceNotFound(ResourceNotFoundException exception) {
		Map<String, String> mensaje = new HashMap<>();
		mensaje.put("mensaje", "Recurso no encontrado: " + exception.getMessage());
		return mensaje;
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> procesarValidacionException(MethodArgumentNotValidException exception) {
		Map<String, String> exceptionMassege = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fielName = ((FieldError) error).getField();
			String errorMassege = error.getDefaultMessage();
			exceptionMassege.put(fielName, errorMassege);
		});
		return exceptionMassege;
	}
}
