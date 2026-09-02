package com.francocouto.ecommerce.service.exeptions;

public class ResourseNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourseNotFoundExeption(Object id) {
		super("Resourse Not Found id." + id);
		
	}

}
