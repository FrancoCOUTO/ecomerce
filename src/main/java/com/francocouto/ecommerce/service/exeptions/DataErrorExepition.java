package com.francocouto.ecommerce.service.exeptions;

public class DataErrorExepition extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataErrorExepition(String msg) {
		super(msg);
	}

}
