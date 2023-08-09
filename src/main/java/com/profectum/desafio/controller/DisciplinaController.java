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

@RestController
@RequestMapping(value="/api")
public class DisciplinaController {
	
	@Autowired
	CriarDisciplina criarDisciplinaService;
	
	@Autowired
	ListarDisciplinas listarDisciplinasService;
	
	@PostMapping("/disciplina")
	public Disciplina add(@RequestBody CriarDisciplinaDto dto) {
		return criarDisciplinaService.execute(dto);
	}
	
	@GetMapping("/disciplinas")
	public List<Disciplina> findAll(){
		return listarDisciplinasService.execute();
	}
	
	@GetMapping("/disciplina/{id}")
	public Disciplina findById(@PathVariable(value = "id")	long id) {
		
	}
	
}
