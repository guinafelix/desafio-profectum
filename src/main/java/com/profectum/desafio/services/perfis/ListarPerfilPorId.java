package com.profectum.desafio.services.perfis;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.models.Perfil;
import com.profectum.desafio.repository.PerfilRepository;

@Service
public class ListarPerfilPorId {

	@Autowired
	PerfilRepository perfilRepository;
	
	public Perfil execute(long id) {
		return perfilRepository.findById(id);
	}
}
