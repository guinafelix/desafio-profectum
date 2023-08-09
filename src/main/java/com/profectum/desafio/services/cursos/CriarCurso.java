package com.profectum.desafio.services.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Curso.CriarCursoDto;
import com.profectum.desafio.repository.CursoRepository;

@Service
public class CriarCurso {
	@Autowired
	CursoRepository cursoRepository;
	
	public void execute(CriarCursoDto dto) {
		
	}
}
