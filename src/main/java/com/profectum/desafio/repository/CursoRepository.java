package com.profectum.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profectum.desafio.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	Curso findById(long id);
}
