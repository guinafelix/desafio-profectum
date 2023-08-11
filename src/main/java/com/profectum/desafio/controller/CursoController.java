package com.profectum.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.profectum.desafio.dto.Curso.CriarCursoDto;
import com.profectum.desafio.dto.Curso.EditarCursoDto;
import com.profectum.desafio.models.Curso;
import com.profectum.desafio.services.cursos.CriarCurso;
import com.profectum.desafio.services.cursos.EditarCurso;
import com.profectum.desafio.services.cursos.ListarCursoPorId;
import com.profectum.desafio.services.cursos.ListarCursos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


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
	
	@Autowired
	EditarCurso editarCursoService;
	
	@PostMapping("/curso")
	@Operation(summary = "Cria um curso.", method = "POST")
	@ApiResponse(responseCode = "201")
	public ResponseEntity<Void> add(@RequestBody() @Valid CriarCursoDto dto) {
		try {
			this.criarCursoService.execute(dto);
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
			return ResponseEntity.ok(this.listarCursosService.execute()); 
		} catch (Error err) {
			System.out.println(err);
		}
		return null;
	}
	
	@PatchMapping("/curso/{id}")
	@Operation(summary = "Edita um curso.", method = "PATCH")
	@ApiResponse(responseCode = "204")
	public ResponseEntity<Void> update(@PathVariable(value = "id")	long id, @RequestBody() @Valid EditarCursoDto dto) {
		try {
			return this.editarCursoService.execute(id, dto);
		} catch (Error err) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
