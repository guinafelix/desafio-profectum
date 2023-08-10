package com.profectum.desafio.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.profectum.desafio.repository.UsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService {
	@Autowired
	UsuarioRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByNome(username);
	}
	
}
