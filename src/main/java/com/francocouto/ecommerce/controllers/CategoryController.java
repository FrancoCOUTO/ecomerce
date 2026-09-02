package com.francocouto.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francocouto.ecommerce.dto.CategoryDTO;
import com.francocouto.ecommerce.service.CategoryServce;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired
	 private CategoryServce catService;
	
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> dto =  catService.findAll();
		return ResponseEntity.ok(dto);
	}
	
}
