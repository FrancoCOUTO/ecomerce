package com.francocouto.ecommerce.dto;

import com.francocouto.ecommerce.entities.Category;

public class CategoryMinDTO {
	
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
