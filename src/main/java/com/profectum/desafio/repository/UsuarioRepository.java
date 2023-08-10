package com.profectum.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profectum.desafio.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
}
