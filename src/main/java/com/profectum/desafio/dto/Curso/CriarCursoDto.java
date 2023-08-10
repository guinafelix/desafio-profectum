package com.profectum.desafio.dto.Curso;

import java.util.List;

import com.profectum.desafio.dto.Oferta.CriarOfertaDto;

public class CriarCursoDto {
	private String nome;
	private int duracaoEmSemestres;
	private List<CriarOfertaDto> ofertas;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDuracaoEmSemestres() {
		return duracaoEmSemestres;
	}
	public void setDuracaoEmSemestres(int duracaoEmSemestres) {
		this.duracaoEmSemestres = duracaoEmSemestres;
	}
	public List<CriarOfertaDto> getofertas() {
		return ofertas;
	}
	public void setofertas(List<CriarOfertaDto> ofertas) {
		this.ofertas = ofertas;
	}
}
