package com.profectum.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Auth.LoginDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name="Auth")
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid LoginDto dto) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getNome(), dto.getSenha());
		var auth = this.authManager.authenticate(usernamePassword);
		
		return ResponseEntity.ok().build();
	}
}
