package com.francocouto.ecommerce.dto;

import com.francocouto.ecommerce.entities.Category;

public class CategoryDTO {
	
	private Long id;
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
