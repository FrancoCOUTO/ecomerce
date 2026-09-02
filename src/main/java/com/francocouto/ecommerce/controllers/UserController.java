package com.francocouto.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.francocouto.ecommerce.dto.UserMinDTO;
import com.francocouto.ecommerce.service.UserServise;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserServise userServise;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@GetMapping(value = "/me")
	public ResponseEntity<UserMinDTO> getMe() {
		UserMinDTO user = userServise.getMe();
		return ResponseEntity.ok(user);
		
	}

}
