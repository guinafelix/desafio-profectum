package com.profectum.desafio.models;

import java.io.Serializable;
import java.util.List;

import com.profectum.desafio.dto.Curso.CriarCursoDto;
import com.profectum.desafio.dto.Curso.EditarCursoDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_CURSO")
public class Curso implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
      private long id;
	
	private String nome;
	
	private int duracaoEmSemestres;
	
	@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Oferta> ofertas;
	
	public Curso(CriarCursoDto dto, List<Oferta> ofertas) {
		super();
		this.nome = dto.getNome();
		this.duracaoEmSemestres = dto.getDuracaoEmSemestres();
		this.ofertas = ofertas;
	}
	
	public Curso(CriarCursoDto dto) {
		super();
		this.nome = dto.getNome();
		this.duracaoEmSemestres = dto.getDuracaoEmSemestres();
	}
	
	public Curso update(Curso curso, EditarCursoDto dto) {
		if (dto.getNome() != null) {
	        curso.setNome(dto.getNome().get());
	    }

	    if (dto.getDuracaoEmSemestres() != null) {
	        curso.setDuracaoEmSemestres(dto.getDuracaoEmSemestres().get());
	    }
		return curso;
	}

	public Curso() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
}
