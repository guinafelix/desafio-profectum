package com.profectum.desafio.models;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
      private long id;
	
	private String nome;
	
	@ManyToOne(targetEntity = Curso.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Curso curso;
	
	private String matricula;
	
	
	public Usuario(String nome, Curso curso, String matricula, List<Perfil> perfis) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
		this.perfis = perfis;
	}


	public Usuario(String nome, Optional<Curso> curso, String matricula, List<Perfil> perfis) {
		super();
		this.nome = nome;
		this.curso = curso != null ? curso.get() : null;
		this.matricula = matricula;
		this.perfis = perfis;
	}


	@OneToMany(targetEntity = Perfil.class, fetch=FetchType.EAGER)
	@JoinColumn(name="perfil_id")
	private List<Perfil> perfis;


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


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public List<Perfil> getPerfis() {
		return perfis;
	}


	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
}
