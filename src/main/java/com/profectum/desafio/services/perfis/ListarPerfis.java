package com.profectum.desafio.services.perfis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.models.Perfil;
import com.profectum.desafio.repository.PerfilRepository;

@Service
public class ListarPerfis {
	@Autowired
	PerfilRepository perfilRepository;
	
	public List<Perfil> execute(){
		return perfilRepository.findAll();
	}
}
