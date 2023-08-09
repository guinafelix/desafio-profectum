package com.profectum.desafio.services.usuarios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		Optional<Curso> curso = cursoRepository.findById(dto.getCursoId());
		
		if (curso == null) {
			return null;
		}
		
		List<Long> perfilIds = dto.getPerfilId();

		List<Perfil> perfis = perfilIds.stream()
                .map(perfilId -> perfilRepository.findById(perfilId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

		
		Usuario user = new Usuario(dto.getNome(), curso,dto.getMatricula(), perfis);
		return user;
	}
	
}
