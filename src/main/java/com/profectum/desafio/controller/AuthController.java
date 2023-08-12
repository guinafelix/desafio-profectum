package com.profectum.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.profectum.desafio.config.JwtTokenService;
import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.dto.Auth.LoginDto;
import com.profectum.desafio.dto.Auth.LoginResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name="Auth")
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtTokenService jwtTokenService;
	
	@PostMapping("/login")
	@Operation(summary = "Faz o login do usuario", method = "POST")
	@ApiResponse(responseCode = "201")
	public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginDto dto) {
		try {
			UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(dto.getNome(), dto.getSenha());
			Authentication auth = this.authManager.authenticate(usernamePassword);
			String token = this.jwtTokenService.generateToken((Usuario) auth.getPrincipal());
			
			return ResponseEntity.ok(new LoginResponseDto(token));
		} catch(Exception err) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
