package com.profectum.desafio.services.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Usuarios.EditarUsuarioDto;
import com.profectum.desafio.models.Curso;
import com.profectum.desafio.models.Perfil;
import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.repository.CursoRepository;
import com.profectum.desafio.repository.PerfilRepository;
import com.profectum.desafio.repository.UsuarioRepository;

@Service
public class EditarUsuario {
	@Autowired
	UsuarioRepository userRepo;
	
	@Autowired 
	PerfilRepository perfilRepo;
	
	@Autowired
	CursoRepository cursoRepo;
	
	public ResponseEntity<Void> execute(Long id, EditarUsuarioDto dto) {
		Usuario user = this.userRepo.findById(id).get();
		
		if (user == null) return ResponseEntity.notFound().build();
		
		if (dto.getMatricula().get() != null)  user.setMatricula(dto.getMatricula().get());
		
		if (dto.getCursoId().get() != null) {
			Curso curso = cursoRepo.findById(dto.getCursoId().get()).get();
			if (curso == null) return ResponseEntity.notFound().build();
			user.setCurso(curso);
		}
		
		if (dto.getNome() != null) user.setNome(dto.getNome().get());
		
		if (dto.getPerfilId().get() != null) {
			Perfil perfil = this.perfilRepo.findById(dto.getPerfilId().get()).get();
			if (perfil == null) return ResponseEntity.notFound().build();
			user.setPerfil(perfil);
		}
		this.userRepo.save(user);
		return ResponseEntity.noContent().build();
	}
}
