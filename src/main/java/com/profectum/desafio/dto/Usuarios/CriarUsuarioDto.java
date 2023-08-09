package com.profectum.desafio.dto.Usuarios;

import java.util.List;

public class CriarUsuarioDto {
	private String nome;
	private List<Long> perfilId;
	private String matricula;
	private long cursoId;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Long> getPerfilId() {
		return perfilId;
	}
	public void setPerfilId(List<Long> perfilId) {
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
