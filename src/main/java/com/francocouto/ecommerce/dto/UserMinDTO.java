package com.francocouto.ecommerce.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.francocouto.ecommerce.entities.User;

public class UserMinDTO {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private LocalDate birthDate;

	List<String> roles = new ArrayList<>();

	public UserMinDTO() {

	}

	public UserMinDTO(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		birthDate = user.getBirthDate();
		for (GrantedAuthority roles : user.getRoles()) {
			this.roles.add(roles.getAuthority());

		}
	}

	public UserMinDTO(Long id, String name, String email, String phone, LocalDate birthDate, List<String> roles) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public List<String> getRoles() {
		return roles;
	}

}
