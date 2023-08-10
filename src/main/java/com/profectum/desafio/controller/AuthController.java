package com.profectum.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.config.JwtTokenService;
import com.profectum.desafio.dto.Auth.LoginDto;
import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.dto.Auth.LoginResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
		var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getNome(), dto.getSenha());
		var auth = this.authManager.authenticate(usernamePassword);
		
		var token = jwtTokenService.generateToken((Usuario) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDto(token));
	}
}
