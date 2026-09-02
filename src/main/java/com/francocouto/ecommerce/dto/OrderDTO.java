package com.francocouto.ecommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.francocouto.ecommerce.entities.Order;
import com.francocouto.ecommerce.entities.OrderItem;
import com.francocouto.ecommerce.enuns.OrderStatus;

import jakarta.validation.constraints.NotEmpty;

public class OrderDTO {
	
	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private UserMinDTO client;
	
	private PaymentDTO payment;
	
	@NotEmpty(message = "O pedido tem que ter pelo meno um iten" )
	private List<OrderItemDTO> items = new ArrayList<>();
	
	
	public OrderDTO(Long id, Instant moment, OrderStatus status, UserMinDTO clent, PaymentDTO payment) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = clent;
		this.payment = payment;
	}

	public OrderDTO(Order order) {
		id = order.getId();
		moment = order.getMoment();
		status = order.getStatus();
		client = new UserMinDTO(order.getClient());
		payment = (order.getPayment() == null ? null : new PaymentDTO(order.getPayment()));
		for(OrderItem item : order.getOrderItem()) {
			items.add(new OrderItemDTO(item));
		}
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public UserMinDTO getClient() {
		return client;
	}

	public PaymentDTO getPayment() {
		return payment;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}
	
	public Double getTotal() {
		Double sum = 0.0;
		for(OrderItemDTO dto : items) {
			sum=+ dto.getSubtotal();
		}
		return sum;
	}
}
