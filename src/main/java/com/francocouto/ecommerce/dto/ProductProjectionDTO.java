package com.francocouto.ecommerce.dto;

import com.francocouto.ecommerce.projections.ProductProjection;

public class ProductProjectionDTO {

	private Long id;
	private String name;
	private String description;
	private String imgUrl;

	public ProductProjectionDTO() {

	}

	public ProductProjectionDTO(Long id, String name, String description, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
	}

	public ProductProjectionDTO(ProductProjection proj) {
		id = proj.getId();
		name = proj.getName();
		description= proj.getDescription();
		imgUrl = proj.getImgUrl();
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

	public String getImgUrl() {
		return imgUrl;
	}
}
