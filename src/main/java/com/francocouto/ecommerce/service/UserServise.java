package com.francocouto.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francocouto.ecommerce.dto.UserDTO;
import com.francocouto.ecommerce.dto.UserInsertDTO;
import com.francocouto.ecommerce.entities.Role;
import com.francocouto.ecommerce.entities.User;
import com.francocouto.ecommerce.projections.UserDetailProjection;
import com.francocouto.ecommerce.repositories.UserRepository;
import com.francocouto.ecommerce.service.exeptions.ResourseNotFoundExeption;

@Service
public class UserServise implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserDetailProjection> proj = userRepo.searchUserAndRolesByEmail(username);

		if (proj.isEmpty()) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
		User user = new User();
		user.setEmail(username);
		user.setPassword(proj.get(0).getPassword());
		for (UserDetailProjection projList : proj) {
			Role role = new Role(projList.getRoleId(), projList.getAuthority());
			user.addRole(role);
		}
		return user;
	}

	protected User authenticated() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (!(authentication.getPrincipal() instanceof Jwt)) {
				throw new UsernameNotFoundException("Usuário não autenticado ou token ausente.");
			}

			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaim("username");

			return userRepo.findByEmail(username).get();

		} catch (Exception e) {
			throw new UsernameNotFoundException("Usuário inválido ou não encontrado");
		}
	}
		@Transactional(readOnly = true)	
		public UserDTO getMe() {
		User user = authenticated();
		return new UserDTO(user);
	}

		@Transactional	
		public UserDTO insert(UserInsertDTO dto) {
			User user = new User();
			user.setEmail(dto.getEmail());
			user.setName(dto.getName());
			user.setBirthDate(dto.getBirthDate());
			user.setPhone(dto.getPhone());
			user.setPassword(encoder.encode(dto.getPassword()));
			Role role = new Role();
			role.setId(1L);
			user.addRole(role);
			userRepo.save(user);
			return new UserDTO(user);
	
		}
		
		public UserDTO update(Long id , UserInsertDTO dto) {
			User user = userRepo.getReferenceById(id);
			
			user.setName(dto.getName());
			user.setEmail(dto.getEmail());
			user.setBirthDate(dto.getBirthDate());
			user.setPhone(dto.getPhone());
			if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
		        user.setPassword(encoder.encode(dto.getPassword()));
		    }
			user = userRepo.save(user);
			return new UserDTO(user);
			
			
		}
		
		public void delete(Long id) {
			userRepo.deleteById(id);
		}

		
}


		



































