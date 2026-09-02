package com.francocouto.ecommerce.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.francocouto.ecommerce.PK.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK() ;
	
	private Integer quantity;
	private Double price;
	
	public OrderItem (){
		
	}

	public OrderItem(Product product, Order order, Integer quantiy, Double price) {
		id.setProduct(product);
		id.setOrder(order);
		this.quantity = quantiy;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
		
	}
	
	public void setOrder(Order order) {
		 id.setOrder(order);
		
	}
	@JsonIgnore
	public Product getProduct() {
		return id.getProduct();
		
	}
	
	public void setProdutc(Product product) {
		 id.setProduct(product);
		
	}

	public Integer getQuantiy() {
		return quantity;
	}

	public void setQuantiy(Integer quantiy) {
		this.quantity = quantiy;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
