package com.francocouto.ecommerce.controllers.exeption;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.francocouto.ecommerce.dto.ValidationError;
import com.francocouto.ecommerce.service.exeptions.DataErrorExepition;
import com.francocouto.ecommerce.service.exeptions.ForbiddenExepition;
import com.francocouto.ecommerce.service.exeptions.ResourseNotFoundExeption;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourseExepitionHandler {

	@ExceptionHandler(ResourseNotFoundExeption.class)
	public ResponseEntity<EstandardError> notFound(ResourseNotFoundExeption e, HttpServletRequest request) {
		String erro = "Not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		EstandardError err = new EstandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}
	@ExceptionHandler(DataErrorExepition.class)
	public ResponseEntity<EstandardError> notFound(DataErrorExepition e, HttpServletRequest request) {
		String erro = "Data Error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		EstandardError err = new EstandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}
	
	@ExceptionHandler(ForbiddenExepition.class)
	public ResponseEntity<EstandardError> notFound(ForbiddenExepition e, HttpServletRequest request) {
		String erro = "Acesso negado";
		HttpStatus status = HttpStatus.FORBIDDEN;
		EstandardError err = new EstandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<EstandardError> notFound(UsernameNotFoundException e, HttpServletRequest request) {
		String erro = "Nao encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		EstandardError err = new EstandardError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<EstandardError> notFound(MethodArgumentNotValidException e, HttpServletRequest request) {
		String erro = "Argumento invalido";
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError err = new ValidationError(Instant.now(), status.value(), erro, e.getMessage(),  request.getRequestURI());
		for(FieldError f :e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
			
		}
		return ResponseEntity.status(status).body(err);
}
}
