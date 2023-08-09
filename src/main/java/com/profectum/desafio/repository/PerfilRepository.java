package com.profectum.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profectum.desafio.dto.Perfil.CriarPerfilDto;
import com.profectum.desafio.models.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{
	Perfil findById(long id);
}
