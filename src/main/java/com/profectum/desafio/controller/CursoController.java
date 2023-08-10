package com.profectum.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Curso.CriarCursoDto;
import com.profectum.desafio.models.Curso;
import com.profectum.desafio.services.cursos.CriarCurso;
import com.profectum.desafio.services.cursos.ListarCursoPorId;
import com.profectum.desafio.services.cursos.ListarCursos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value="/api")
@Tag(name = "Curso")
public class CursoController {
	@Autowired
	ListarCursos listarCursosService;
	
	@Autowired
	ListarCursoPorId ListarCursoPorIdService;
	
	@Autowired
	CriarCurso criarCursoService;
	
	@PostMapping("/curso")
	@Operation(summary = "Cria um curso.", method = "POST")
	@ApiResponse(responseCode = "201")
	public ResponseEntity<Void> add(@RequestBody() @Valid CriarCursoDto dto) {
		try {
			criarCursoService.execute(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/cursos")
	@Operation(summary = "Lista todos os usuários", method = "GET")
	@ApiResponse(responseCode = "200")
	public ResponseEntity<List<Curso>> findAll(){
		try {
			return ResponseEntity.ok(listarCursosService.execute());
		} catch (Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
