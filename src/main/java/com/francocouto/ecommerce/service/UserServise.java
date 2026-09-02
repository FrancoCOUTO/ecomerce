package com.francocouto.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francocouto.ecommerce.dto.UserMinDTO;
import com.francocouto.ecommerce.entities.Role;
import com.francocouto.ecommerce.entities.User;
import com.francocouto.ecommerce.projections.UserDetailProjection;
import com.francocouto.ecommerce.repositories.UserRepository;

@Service
public class UserServise implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

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
		public UserMinDTO getMe() {
		User user = authenticated();
		return new UserMinDTO(user);
	}

}
