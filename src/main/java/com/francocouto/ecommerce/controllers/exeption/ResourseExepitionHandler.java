package com.francocouto.ecommerce.controllers.exeption;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.francocouto.ecommerce.service.exeptions.DataErrorExepition;
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
}
