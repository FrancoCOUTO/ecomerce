package com.francocouto.ecommerce.dto;

import java.time.Instant;

import com.francocouto.ecommerce.entities.Payment;

public class PaymentDTO {

	private Long id;
	private Instant moment;
	
	
	public PaymentDTO(Long id, Instant instant) {
		this.id = id;
		this.moment = instant;
	}
	
	
	public PaymentDTO(Payment payment) {
		id = payment.getId();
		moment = payment.getMoment();
		
	}


	public Long getId() {
		return id;
	}


	public Instant getMoment() {
		return moment;
	}



	
}
