package com.profectum.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profectum.desafio.models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	Disciplina findById(long id);
}
