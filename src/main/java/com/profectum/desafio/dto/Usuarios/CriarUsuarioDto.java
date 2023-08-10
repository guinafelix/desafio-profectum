package com.profectum.desafio.dto.Usuarios;

import java.util.Optional;

public class CriarUsuarioDto {
	private String nome;
	private long perfilId;
	private Optional<String> matricula;
	private Optional<Long> cursoId;
	private String senha;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getPerfilId() {
		return perfilId;
	}
	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}
	public Optional<String> getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = Optional.ofNullable(matricula);
	}
	public Optional<Long> getCursoId() {
		return cursoId;
	}
	public void setCursoId(Long cursoId) {
		this.cursoId = Optional.ofNullable(cursoId);
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
