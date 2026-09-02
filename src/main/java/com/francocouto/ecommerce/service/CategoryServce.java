package com.francocouto.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francocouto.ecommerce.dto.CategoryDTO;
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

}
