package com.francocouto.ecommerce.dto;

public class FildMesage {

	private String fieldName;
	private String message;
	
	public FildMesage(String fildName, String message) {
		super();
		this.fieldName = fildName;
		this.message = message;
	}

	public String getFildName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setFildName(String fildName) {
		this.fieldName = fildName;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
