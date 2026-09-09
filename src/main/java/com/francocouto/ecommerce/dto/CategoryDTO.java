package com.francocouto.ecommerce.dto;

import com.francocouto.ecommerce.entities.Category;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {
	
	@NotBlank(message = "O campo id nao pode ser nulo")
	private Long id;
	@NotBlank(message = "O campo nome nao pode ser nulo")
	private String name;
	
	
	public CategoryDTO(){
		
	}
	
	public CategoryDTO(Category cat) {
		id = cat.getId();
		name = cat.getName();
		
	}

	public CategoryDTO(Long id, String name) {
		super();
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
