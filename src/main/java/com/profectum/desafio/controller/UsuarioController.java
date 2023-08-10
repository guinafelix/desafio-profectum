package com.profectum.desafio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Usuarios.CriarUsuarioDto;
import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.services.usuarios.ListarUsuarios;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.profectum.desafio.services.usuarios.CriarUsuario; 


@RestController
@RequestMapping(value="/api")
@Tag(name = "Usuário")
public class UsuarioController {
	
	@Autowired
	ListarUsuarios listarUsuariosService;
	
	@Autowired 
	CriarUsuario criarUsuarioService;
	
	
	@GetMapping("/usuarios")
	@Operation(summary = "Lista todos os usuários", method = "GET")
	@ApiResponse(responseCode = "200")
	public ResponseEntity<List<Usuario>> findAll() {
		try {
			return ResponseEntity.ok(listarUsuariosService.execute());	
		}catch (Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/usuario")
	@Operation(summary = "Cria um usuário", method = "POST")
	@ApiResponse(responseCode = "201")
	public ResponseEntity<Void> add(@RequestBody CriarUsuarioDto dto) {
		try {
			criarUsuarioService.execute(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch(Error err) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}