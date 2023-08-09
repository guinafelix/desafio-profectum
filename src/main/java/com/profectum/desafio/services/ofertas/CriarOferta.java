package com.profectum.desafio.services.ofertas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Oferta.CriarOfertaDto;
import com.profectum.desafio.models.Curso;
import com.profectum.desafio.models.Disciplina;
import com.profectum.desafio.models.Oferta;
import com.profectum.desafio.repository.CursoRepository;
import com.profectum.desafio.repository.DisciplinaRepository;
import com.profectum.desafio.repository.OfertaRepository;

@Service
public class CriarOferta {
	@Autowired
	OfertaRepository ofertaRepository;
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	public Oferta execute(CriarOfertaDto dto) {
		Curso curso = cursoRepository.findById(dto.getCursoId());
		
		Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId());
		
		Oferta oferta = new Oferta(curso, disciplina, dto.getSemestre());
		
		return ofertaRepository.save(oferta);
	}
}
