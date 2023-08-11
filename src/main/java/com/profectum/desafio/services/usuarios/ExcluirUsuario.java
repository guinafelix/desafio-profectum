package com.profectum.desafio.services.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.profectum.desafio.repository.UsuarioRepository;

@Service
public class ExcluirUsuario {
	@Autowired
	UsuarioRepository userRepo;
	
	public ResponseEntity<Void> execute(Long id) {
		if (this.userRepo.findById(id) == null) return ResponseEntity.notFound().build();
		
		this.userRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
