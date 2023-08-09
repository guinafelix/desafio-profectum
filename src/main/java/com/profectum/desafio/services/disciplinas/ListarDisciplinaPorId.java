package com.profectum.desafio.services.disciplinas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.models.Disciplina;
import com.profectum.desafio.repository.DisciplinaRepository;

@Service
public class ListarDisciplinaPorId {
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	public Disciplina execute(long id){
		return disciplinaRepository.findById(id);
	}
}
