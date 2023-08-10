package com.profectum.desafio.services.ofertas;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Oferta.CriarOfertaDto;
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
		List<Long> disciplinasId = dto.getDisciplinasId();

		List<Disciplina> disciplinas = disciplinasId.stream()
                .map(disciplinaId -> disciplinaRepository.findById(disciplinaId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
		
		Oferta oferta = new Oferta(disciplinas, dto.getSemestre());
		
		return ofertaRepository.save(oferta);
	}
}
