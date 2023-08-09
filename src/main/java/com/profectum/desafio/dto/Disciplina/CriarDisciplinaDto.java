package com.profectum.desafio.dto.Disciplina;

import com.profectum.desafio.models.Disciplina;

public class CriarDisciplinaDto {
	private String nome;
	private int cargaHoraria;
	
	public Disciplina transform() {
		return new Disciplina(nome, cargaHoraria);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
