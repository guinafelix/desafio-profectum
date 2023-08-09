package com.profectum.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profectum.desafio.models.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Long>{
	
}
