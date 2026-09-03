package com.francocouto.ecommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.francocouto.ecommerce.controllers.exeption.EstandardError;

public class ValidationError extends EstandardError {

	List<FildMesage> erros = new ArrayList<>();

	public ValidationError(Instant time, Integer status, String erro, String mensagem, String path) {
		super(time, status, erro, mensagem, path);
	}

	public List<FildMesage> getErros() {
		return erros;
	}

	public void addError(String name , String message) {
		erros.removeIf(x-> x.getFildName().equals(name));
		erros.add(new FildMesage(name, message));
	}
	
	
	
	
	
	
}
