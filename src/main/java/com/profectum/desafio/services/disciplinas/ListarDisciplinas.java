package com.profectum.desafio.services.disciplinas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.models.Disciplina;
import com.profectum.desafio.repository.DisciplinaRepository;

@Service
public class ListarDisciplinas {
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	public List<Disciplina> execute(){
		return disciplinaRepository.findAll();
	}
}
