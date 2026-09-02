package com.francocouto.ecommerce.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francocouto.ecommerce.dto.CategoryDTO;
import com.francocouto.ecommerce.dto.ProductMinDTO;

import com.francocouto.ecommerce.dto.ProductProjectionDTO;
import com.francocouto.ecommerce.entities.Category;
import com.francocouto.ecommerce.entities.Product;
import com.francocouto.ecommerce.projections.ProductProjection;
import com.francocouto.ecommerce.repositories.CategoryRepository;
import com.francocouto.ecommerce.repositories.ProductRepository;

@Service
public class ProductServise {

	@Autowired
	private ProductRepository Prodrepo;
	
	@Autowired
	private CategoryRepository catRepo;

	

	@Transactional(readOnly = true)
	public Page<ProductProjectionDTO> searchByName( String name ,Pageable pageable) {
		Page<ProductProjection> prod = Prodrepo.searchByName(name, pageable);
		Page<ProductProjectionDTO> dto = prod.map(x-> new ProductProjectionDTO(x));
		return dto;
	}

	@Transactional
	public ProductMinDTO insert(ProductMinDTO dto) {
		Product product = new Product();
		product.setId(dto.getId());
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setImgUrl(dto.getImgUrl());
		for(CategoryDTO category : dto.getCat()) {
			Category cat = catRepo.getReferenceById(category.getId());
			product.getCategories().add(cat);
			Prodrepo.save(product);
			
		}
		return new ProductMinDTO(product);

	}

	@Transactional
	public ProductMinDTO update(Long id, ProductMinDTO dto) {
		Product product = Prodrepo.getReferenceById(id);
		dtoFromEntity(dto, product);
		product = Prodrepo.save(product);
		return new ProductMinDTO(product);
	}

	@Transactional
	public void delete(Long id) {
		Prodrepo.deleteById(id);
	}

	private void dtoFromEntity(ProductMinDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());
	}
}
