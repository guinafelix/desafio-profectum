package com.profectum.desafio.services.cursos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.models.Curso;
import com.profectum.desafio.repository.CursoRepository;

@Service
public class ListarCursoPorId {
	@Autowired
	CursoRepository cursoRepository;
	
	public Optional<Curso> execute(Long id){
		return cursoRepository.findById(id);
	}
}
