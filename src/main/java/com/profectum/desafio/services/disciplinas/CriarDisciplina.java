package com.profectum.desafio.services.disciplinas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Disciplina.CriarDisciplinaDto;
import com.profectum.desafio.models.Disciplina;
import com.profectum.desafio.repository.DisciplinaRepository;

@Service
public class CriarDisciplina {
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	public Disciplina execute(CriarDisciplinaDto dto) {
		return disciplinaRepository.save(dto.transform());
	}
}
