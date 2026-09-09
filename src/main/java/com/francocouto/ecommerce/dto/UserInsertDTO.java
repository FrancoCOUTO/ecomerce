package com.francocouto.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInsertDTO extends UserDTO {
	
	@NotBlank(message = "Campo requerido")
	@Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
	private String password;
	
	public UserInsertDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
