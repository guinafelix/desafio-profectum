package com.profectum.desafio.services.usuarios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Usuarios.CriarUsuarioDto;
import com.profectum.desafio.models.Curso;
import com.profectum.desafio.models.Perfil;
import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.repository.CursoRepository;
import com.profectum.desafio.repository.PerfilRepository;
import com.profectum.desafio.repository.UsuarioRepository;

@Service
public class CriarUsuario {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	PerfilRepository perfilRepository;
	
	public Usuario execute(CriarUsuarioDto dto) {
		Optional<Curso> curso = Optional.empty();
		
		Optional<String> matricula = dto.getMatricula() != null ? Optional.ofNullable(dto.getMatricula().get()) : Optional.empty();
		
		if (dto.getCursoId() != null && dto.getCursoId().isPresent()) {
			curso = cursoRepository.findById(dto.getCursoId().get());
		}
		
		Optional<Perfil> perfil = perfilRepository.findById(dto.getPerfilId());

		Usuario user = new Usuario(dto.getNome(), curso.orElse(null), matricula.orElse(null), perfil.get(), dto.getSenha());
		return usuarioRepository.save(user);
	}
	
}
