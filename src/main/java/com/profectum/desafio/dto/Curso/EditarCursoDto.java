package com.profectum.desafio.dto.Curso;

import java.util.List;
import java.util.Optional;

import com.profectum.desafio.dto.Oferta.CriarOfertaDto;

public class EditarCursoDto {
	private Optional<String> nome;
	private Optional<Integer> duracaoEmSemestres;
	private Optional<List<CriarOfertaDto>> ofertas;
	
	
	public Optional<String> getNome() {
		return nome;
	}
	public void setNome(Optional<String> nome) {
		this.nome = nome;
	}
	public Optional<Integer> getDuracaoEmSemestres() {
		return duracaoEmSemestres;
	}
	public void setDuracaoEmSemestres(Optional<Integer> duracaoEmSemestres) {
		this.duracaoEmSemestres = duracaoEmSemestres;
	}
	public Optional<List<CriarOfertaDto>> getOfertas() {
		return ofertas;
	}
	public void setOfertas(Optional<List<CriarOfertaDto>> ofertas) {
		this.ofertas = ofertas;
	}
	
	
}
