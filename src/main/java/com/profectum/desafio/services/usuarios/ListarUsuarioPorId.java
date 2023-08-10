package com.profectum.desafio.services.usuarios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.repository.UsuarioRepository;

@Service
public class ListarUsuarioPorId {
	@Autowired
	UsuarioRepository userRepo;
	
	public ResponseEntity<Optional<Usuario>> execute(Long id) {
		Optional<Usuario> user = this.userRepo.findById(id);
		return ResponseEntity.ok(user);
	}
}
