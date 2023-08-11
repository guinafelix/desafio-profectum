package com.profectum.desafio.dto.Usuarios;

import java.util.Optional;

public class EditarUsuarioDto {
	Optional<String> nome;
	Optional<String> matricula;
	Optional<Long> perfilId;
	Optional<Long> cursoId;
	
	public Optional<String> getNome() {
		return nome;
	}
	public void setNome(Optional<String> nome) {
		this.nome = nome;
	}
	public Optional<String> getMatricula() {
		return matricula;
	}
	public void setMatricula(Optional<String> matricula) {
		this.matricula = matricula;
	}
	public Optional<Long> getPerfilId() {
		return perfilId;
	}
	public void setPerfilId(Optional<Long> perfilId) {
		this.perfilId = perfilId;
	}
	public Optional<Long> getCursoId() {
		return cursoId;
	}
	public void setCursoId(Optional<Long> cursoId) {
		this.cursoId = cursoId;
	}
	
	
}
