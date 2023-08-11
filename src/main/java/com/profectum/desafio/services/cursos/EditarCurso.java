package com.profectum.desafio.services.cursos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Curso.EditarCursoDto;
import com.profectum.desafio.dto.Oferta.CriarOfertaDto;
import com.profectum.desafio.models.Curso;
import com.profectum.desafio.models.Oferta;
import com.profectum.desafio.repository.CursoRepository;
import com.profectum.desafio.services.ofertas.CriarOferta;

@Service
public class EditarCurso {
		@Autowired
		CursoRepository cursoRepo;
		@Autowired
		CriarOferta criarOfertaService;
		
		public ResponseEntity<Void> execute(Long id, EditarCursoDto dto) {
			Optional<Curso> curso = this.cursoRepo.findById(id);
			
			if (curso == null) {
				return ResponseEntity.badRequest().build();
			}
			
			System.out.println(dto.getDuracaoEmSemestres());
			
			List<Oferta> ofertas = new ArrayList<>();
			if (dto.getOfertas() != null) {
				ofertas = new ArrayList<>();
			
				List<CriarOfertaDto> listaDeOfertas = dto.getOfertas().get();
				
				for (CriarOfertaDto criarOfertaDto : listaDeOfertas) {
				    Oferta oferta = this.criarOfertaService.execute(criarOfertaDto, curso.get()); 
				    ofertas.add(oferta);
				}
				
				curso.get().setOfertas(ofertas);
			}
			Curso updatedCurso = curso.get().update(curso.get(), dto);
			this.cursoRepo.save(updatedCurso);
			return ResponseEntity.noContent().build();
		}
}
