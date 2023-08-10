package com.profectum.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.profectum.desafio.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    UserDetails findByNome(String nome);
    Optional<Usuario> findById(Long id);
}
