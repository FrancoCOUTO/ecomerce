package com.francocouto.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francocouto.ecommerce.dto.CategoryDTO;
import com.francocouto.ecommerce.dto.CategoryMinDTO;
import com.francocouto.ecommerce.entities.Category;
import com.francocouto.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryServce {
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> dto = catRepo.findAll();
		return dto.stream().map(x -> new CategoryDTO(x)).toList();
		
	}
	
	
	@Transactional
	public CategoryDTO insert(CategoryDTO cat) {
		Category category = new Category();
		category.setNome(cat.getName());
		catRepo.save(category);
		return new CategoryDTO(category);
		
	}

	@Transactional
	public CategoryDTO update(Long id, CategoryMinDTO cat) {
		Category category = catRepo.getReferenceById(id);
		category.setNome(cat.getName());
		catRepo.save(category);
		return new CategoryDTO(category);
	}


	@Transactional
	public void delete(Long id) {
		catRepo.deleteById(id);
	}
	
}