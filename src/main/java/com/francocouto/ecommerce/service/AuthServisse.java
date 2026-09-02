package com.francocouto.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francocouto.ecommerce.entities.User;
import com.francocouto.ecommerce.service.exeptions.ForbiddenExepition;

@Service
public class AuthServisse {
	
	@Autowired
	private UserServise userServise;

	public void validationSelfOrAdimin (Long id) {
		User user = userServise.authenticated();
		if(!user.hasAuthority("ROLE_ADMIN") && (!user.getId().equals(id))) {
			throw new ForbiddenExepition("Acesso nagado");
			
		}
	}
}
