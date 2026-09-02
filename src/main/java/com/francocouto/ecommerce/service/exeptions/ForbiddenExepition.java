package com.francocouto.ecommerce.service.exeptions;

public class ForbiddenExepition extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ForbiddenExepition(String msg) {
		super(msg);
	}

}
