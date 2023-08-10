package com.profectum.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Perfil.CriarPerfilDto;
import com.profectum.desafio.models.Perfil;
import com.profectum.desafio.services.perfis.CriarPerfil;
import com.profectum.desafio.services.perfis.ListarPerfilPorId;
import com.profectum.desafio.services.perfis.ListarPerfis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/api", produces = {"application/json"})
@Tag(name = "Perfil")
public class PerfilController {
	@Autowired
	CriarPerfil criarPerfilService;
	
	@Autowired 
	ListarPerfilPorId listarPerfilPorIdService;
	
	@Autowired
	ListarPerfis listarPerfisService;
	
	@GetMapping("/perfis")
	@Operation(summary = "Lista todos os perfis.", method = "GET")
	@ApiResponse(responseCode = "200")
	public ResponseEntity<List<Perfil>> findAll(){
		try {
			return ResponseEntity.ok(listarPerfisService.execute());
		} catch(Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/perfil")
	@ApiResponse(responseCode = "201")
	@Operation(summary = "Cria um perfil de usário.", method = "POST")
	public ResponseEntity<Void> add(@RequestBody CriarPerfilDto dto) {
		try {
			criarPerfilService.execute(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch(Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/perfil/{id}")
	@Operation(summary = "Lista um perfil por Id.", method = "GET")
	@ApiResponse(responseCode = "200")
	public ResponseEntity<Perfil> findById(@PathVariable(value = "id")	long id) {
		try {
			return ResponseEntity.ok(listarPerfilPorIdService.execute(id)) ;
		} catch (Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
