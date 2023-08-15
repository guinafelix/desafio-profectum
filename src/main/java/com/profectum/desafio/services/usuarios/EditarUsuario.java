package com.profectum.desafio.services.usuarios;

import java.util.Optional;

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
		
		if (user == null) {
		    return ResponseEntity.notFound().build();
		}

		if (dto.getMatricula().isPresent()) {
		    user.setMatricula(dto.getMatricula().get());
		}

		if (dto.getCursoId().isPresent()) {
		    Optional<Curso> cursoOptional = cursoRepo.findById(dto.getCursoId().get());
		    if (!cursoOptional.isPresent()) {
		        return ResponseEntity.notFound().build();
		    }
		    user.setCurso(cursoOptional.get());
		}

		if (dto.getNome().isPresent()) {
		    user.setNome(dto.getNome().get());
		}

		if (dto.getPerfilId().isPresent()) {
		    Optional<Perfil> perfilOptional = perfilRepo.findById(dto.getPerfilId().get());
		    if (!perfilOptional.isPresent()) {
		        return ResponseEntity.notFound().build();
		    }
		    user.setPerfil(perfilOptional.get());
		}

		userRepo.save(user);
		return ResponseEntity.noContent().build();
	}
}
