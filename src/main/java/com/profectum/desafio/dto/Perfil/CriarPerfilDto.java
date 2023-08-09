package com.profectum.desafio.dto.Perfil;

import com.profectum.desafio.models.Perfil;

public class CriarPerfilDto {
	private String nome;
	
	public Perfil transform() {
		return new Perfil(nome);
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}
}
