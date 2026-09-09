package com.francocouto.ecommerce.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.francocouto.ecommerce.dto.UserDTO;
import com.francocouto.ecommerce.dto.UserInsertDTO;
import com.francocouto.ecommerce.service.UserServise;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserServise userServise;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@GetMapping(value = "/me")
	public ResponseEntity<UserDTO> getMe() {
		UserDTO user = userServise.getMe();
		return ResponseEntity.ok(user);
		
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO user){
		UserDTO dto = userServise.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserInsertDTO dto){
		UserDTO userDto = userServise.update(id, dto);
		return ResponseEntity.ok().body(userDto);
		
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delet(@PathVariable Long id){
		userServise.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
















