package com.francocouto.ecommerce.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.francocouto.ecommerce.dto.ProductMinDTO;
import com.francocouto.ecommerce.dto.ProductProjectionDTO;

import com.francocouto.ecommerce.service.ProductServise;


import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/product")

public class ProductController {

	@Autowired
	ProductServise servise;

	@GetMapping
	public ResponseEntity<Page<ProductProjectionDTO>> searchByName(@RequestParam(defaultValue = "") String name, Pageable page) {
		Page<ProductProjectionDTO> dto = servise.searchByName(name, page);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductMinDTO> findById(@PathVariable Long id) {
			ProductMinDTO dto = servise.findById(id);
			return ResponseEntity.ok().body(dto);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<ProductMinDTO> insert(@Valid @RequestBody ProductMinDTO dto) {
		dto = servise.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductMinDTO> update(@PathVariable Long id, @Valid @RequestBody ProductMinDTO dto) {
		dto = servise.update(id, dto);
		return ResponseEntity.ok(dto);

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		servise.delete(id);
		return ResponseEntity.noContent().build();

	}

}
