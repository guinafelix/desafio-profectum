package com.profectum.desafio.dto.Usuarios;

import java.util.List;

public class CriarUsuarioDto {
	private String nome;
	private long perfilId;
	private String matricula;
	private long cursoId;
	
	
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Long getCursoId() {
		return cursoId;
	}
	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
	
	
}
