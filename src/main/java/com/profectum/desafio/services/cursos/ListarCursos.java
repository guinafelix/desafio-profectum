package com.profectum.desafio.services.cursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.models.Curso;
import com.profectum.desafio.repository.CursoRepository;

@Service
public class ListarCursos {
	@Autowired
	CursoRepository cursoRepository;
	
	public List<Curso> execute(){
		return cursoRepository.findAll();
	}
}
