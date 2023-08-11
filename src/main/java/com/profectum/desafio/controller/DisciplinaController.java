package com.profectum.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profectum.desafio.dto.Disciplina.CriarDisciplinaDto;
import com.profectum.desafio.models.Disciplina;
import com.profectum.desafio.services.disciplinas.CriarDisciplina;
import com.profectum.desafio.services.disciplinas.ListarDisciplinaPorId;
import com.profectum.desafio.services.disciplinas.ListarDisciplinas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/api")
@Tag(name = "Disciplina")
public class DisciplinaController {
	
	@Autowired
	CriarDisciplina criarDisciplinaService;
	
	@Autowired
	ListarDisciplinas listarDisciplinasService;
	
	@Autowired
	ListarDisciplinaPorId listarDisciplinaPorId;
	
	@PostMapping("/disciplina")
	@Operation(summary = "Cria uma disciplina", method = "POST")
	@ApiResponse(responseCode = "201")
	public Disciplina add(@RequestBody  @Valid CriarDisciplinaDto dto) {
		return this.criarDisciplinaService.execute(dto);
	}
	
	@GetMapping("/disciplinas")
	@Operation(summary = "Lista todas as disciplinas", method = "GET")
	@ApiResponse(responseCode = "200")
	public List<Disciplina> findAll(){
		return this.listarDisciplinasService.execute();
	}
	
	@GetMapping("/disciplina/{id}")
	@Operation(summary = "Lista uma disciplina pelo seu id.", method = "GET")
	@ApiResponse(responseCode = "200")
	public Disciplina findById(@PathVariable(value = "id")	long id) {
		return this.listarDisciplinaPorId.execute(id);
	}
	
}
