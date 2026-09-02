package com.francocouto.ecommerce.dto;

import com.francocouto.ecommerce.entities.OrderItem;

public class OrderItemDTO {
	
	private Long productId;
	private String nome;
	private Double price;
	private Integer quantity;
	private String imgUrl;
	
	
	public OrderItemDTO(Long productId, String nome, Double price, Integer quantity, String imgUrl) {
		this.productId = productId;
		this.nome = nome;
		this.price = price;
		this.quantity = quantity;
		this.imgUrl = imgUrl;
	}
	
	public OrderItemDTO (OrderItem item) {
		productId =  item.getProduct().getId();
		nome = item.getProduct().getName();
		price = item.getProduct().getPrice();
		quantity = item.getQuantiy();
		imgUrl = item.getProduct().getImgUrl();
		
	}

	public Long getProductId() {
		return productId;
	}

	public String getNome() {
		return nome;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}
	

	public String getImgUrl() {
		return imgUrl;
	}

	public Double getSubtotal() {
		return price * quantity;
	}

}
