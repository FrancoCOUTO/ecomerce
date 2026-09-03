package com.francocouto.ecommerce.dto;

import com.francocouto.ecommerce.entities.User;

public class UserMinDTO {

	private Long id;
	private String name;

	public UserMinDTO(User client) {
		id = client.getId();
		name = client.getName();

	}

	public UserMinDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
