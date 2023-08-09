package com.profectum.desafio.services.perfis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profectum.desafio.dto.Perfil.CriarPerfilDto;
import com.profectum.desafio.models.Perfil;
import com.profectum.desafio.repository.PerfilRepository;

@Service
public class CriarPerfil {
		@Autowired
		PerfilRepository perfilRepository;
		
		public Perfil execute(CriarPerfilDto dto) {
			return perfilRepository.add(dto);
		}
}
