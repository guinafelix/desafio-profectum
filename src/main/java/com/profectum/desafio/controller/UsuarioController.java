package com.profectum.desafio.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Usuarios.CriarUsuarioDto;
import com.profectum.desafio.dto.Usuarios.EditarUsuarioDto;
import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.services.usuarios.ListarUsuarios;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import com.profectum.desafio.services.usuarios.CriarUsuario;
import com.profectum.desafio.services.usuarios.EditarUsuario;
import com.profectum.desafio.services.usuarios.ExcluirUsuario;
import com.profectum.desafio.services.usuarios.ListarUsuarioPorId; 


@RestController
@RequestMapping(value="/api")
@Tag(name = "Usuário")
public class UsuarioController {
	
	@Autowired
	ListarUsuarios listarUsuariosService;
	
	@Autowired 
	CriarUsuario criarUsuarioService;
	
	@Autowired
	ListarUsuarioPorId listarUsuarioPorIdService;
	
	@Autowired
	EditarUsuario editarUsuarioService;
	
	@Autowired
	ExcluirUsuario excluirUsuarioService;
	
	@GetMapping("/usuarios")
	@Operation(summary = "Lista todos os usuários", method = "GET")
	@ApiResponse(responseCode = "200")
	public ResponseEntity<List<Usuario>> findAll() {
		try {
			return ResponseEntity.ok(this.listarUsuariosService.execute());	
		}catch (Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/usuario/{id}")
	@Operation(summary = "Lista um usuário pelo seu id.", method = "GET")
	@ApiResponse(responseCode = "200")
	public ResponseEntity<Optional<Usuario>> findbyId(@PathVariable(value = "id")	long id) {
		try {
			return this.listarUsuarioPorIdService.execute(id);	
		}catch (Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/usuario")
	@Operation(summary = "Cria um usuário", method = "POST")
	@ApiResponse(responseCode = "201")
	public ResponseEntity<Void> add(@RequestBody @Valid CriarUsuarioDto dto) {
		try {
			this.criarUsuarioService.execute(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch(Error err) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PatchMapping("/usuario/{id}")
	@Operation(summary = "edita um usuário", method = "PATCH")
	@ApiResponse(responseCode = "201")
	public ResponseEntity<Void> update(@PathVariable(value = "id")	long id, @RequestBody @Valid EditarUsuarioDto dto) {
		try {
			this.editarUsuarioService.execute(id, dto);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Error err) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/usuario/{id}")
	@Operation(summary = "remove um usuário", method = "DELETE")
	@ApiResponse(responseCode = "201")
	public ResponseEntity<Void> delete(@PathVariable(value = "id")	long id) {
		try {
			this.excluirUsuarioService.execute(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Error err) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}