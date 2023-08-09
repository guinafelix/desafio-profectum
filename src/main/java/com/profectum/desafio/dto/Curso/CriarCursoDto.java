package com.profectum.desafio.dto.Curso;

import java.util.List;

import com.profectum.desafio.dto.Oferta.CriarOfertaDto;

public class CriarCursoDto {
	private String nome;
	private int duracaoEmSemetres;
	private List<CriarOfertaDto> criarOfertasDto;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDuracaoEmSemetres() {
		return duracaoEmSemetres;
	}
	public void setDuracaoEmSemetres(int duracaoEmSemetres) {
		this.duracaoEmSemetres = duracaoEmSemetres;
	}
	public List<CriarOfertaDto> getCriarOfertasDto() {
		return criarOfertasDto;
	}
	public void setCriarOfertasDto(List<CriarOfertaDto> criarOfertasDto) {
		this.criarOfertasDto = criarOfertasDto;
	}
}
