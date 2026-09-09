package com.francocouto.ecommerce.dto;

import com.francocouto.ecommerce.entities.Category;

import jakarta.validation.constraints.NotBlank;

public class CategoryMinDTO {
	
	@NotBlank(message = "O campo nome nao pode ser nulo")
	private String name;
	
	public CategoryMinDTO () {
		
	}

	public CategoryMinDTO(String name) {
		super();
		this.name = name;
	}
	
	public CategoryMinDTO (Category cat) {
		name = cat.getName();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
