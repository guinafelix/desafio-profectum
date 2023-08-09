package com.profectum.desafio.services.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.models.Usuario;
import com.profectum.desafio.repository.UsuarioRepository;

@Service
public class ListarUsuarios {
	
	@Autowired
	UsuarioRepository usuarioRepostiry;
	
	public List<Usuario> execute() {
		return usuarioRepostiry.findAll();
	}
}
