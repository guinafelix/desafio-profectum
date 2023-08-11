package com.profectum.desafio.services.cursos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Curso.EditarCursoDto;
import com.profectum.desafio.dto.Oferta.CriarOfertaDto;
import com.profectum.desafio.models.Curso;
import com.profectum.desafio.models.Oferta;
import com.profectum.desafio.repository.CursoRepository;
import com.profectum.desafio.repository.OfertaRepository;
import com.profectum.desafio.services.ofertas.CriarOferta;

@Service
public class EditarCurso {
		@Autowired
		CursoRepository cursoRepo;
		@Autowired
		CriarOferta criarOfertaService;
		@Autowired
		OfertaRepository ofertaRepo;
		
		public ResponseEntity<Void> execute(Long id, EditarCursoDto dto) {
			Curso curso = this.cursoRepo.findById(id).get();
			
			if (curso == null) {
				return ResponseEntity.notFound().build();
			}
			
			List<Oferta> ofertas = new ArrayList<>();
			if (dto.getOfertas().get() != null) {
				
				List<CriarOfertaDto> listaDeOfertas = dto.getOfertas().get();
				
				for (Oferta oferta : curso.getOfertas()) {
					oferta.setCurso(null);
					oferta.setDisciplinas(null);
					this.ofertaRepo.delete(oferta);
				}
				
				curso.setOfertas(null);
				
				for (CriarOfertaDto criarOferta : listaDeOfertas) {
					ofertas.add(this.criarOfertaService.execute(criarOferta, curso));
				}
				curso.setOfertas(ofertas);
			}
			Curso updatedCurso = curso.update(curso, dto);
			this.cursoRepo.save(updatedCurso);
			return ResponseEntity.noContent().build();
		}
}
