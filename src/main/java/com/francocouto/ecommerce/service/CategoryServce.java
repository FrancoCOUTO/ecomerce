package com.francocouto.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.francocouto.ecommerce.dto.CategoryDTO;
import com.francocouto.ecommerce.dto.CategoryMinDTO;
import com.francocouto.ecommerce.entities.Category;
import com.francocouto.ecommerce.repositories.CategoryRepository;
import com.francocouto.ecommerce.service.exeptions.DataErrorExepition;
import com.francocouto.ecommerce.service.exeptions.ResourseNotFoundExeption;

@Service
public class CategoryServce {

	@Autowired
	private CategoryRepository catRepo;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
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
		if (!catRepo.existsById(id)) {
			throw new ResourseNotFoundExeption(id);
		}
		Category category = catRepo.getReferenceById(id);
		category.setNome(cat.getName());
		catRepo.save(category);
		return new CategoryDTO(category);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!catRepo.existsById(id)) {
			throw new ResourseNotFoundExeption(id);
		}
		try {
			catRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataErrorExepition("Integridade referencial violada");
		}
	}

}
