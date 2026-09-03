package com.francocouto.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import com.francocouto.ecommerce.entities.Category;
import com.francocouto.ecommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductMinDTO {

	private Long id;
	@NotBlank(message = "Campo requerido")
	@Size(min = 10, max = 30, message = "Esse campo precisa ter entre 10 e 30 caracteres")
	private String name;
	@NotBlank(message = "Campo requerido")
	@Size(min = 10, max = 300, message = "Esse campo precisa ter entre 10 e 300 caracteres")
	private String description;
	@NotNull(message = "O preço não pode ser nulo")
	@Positive(message = "O preco deve ser posotivo")
	private Double price;
	private String imgUrl;

	@NotEmpty(message = "Deve ter pelo menos uma categoria")
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductMinDTO() {

	}

	public ProductMinDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
		for(Category cat : entity.getCategories()) {
			categories.add(new CategoryDTO(cat));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public List<CategoryDTO> getCat() {
		return categories;
	}
}
