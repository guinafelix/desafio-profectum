package com.profectum.desafio.models;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
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
	
	@OneToMany(mappedBy = "curso")
    private List<Oferta> ofertas;

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
