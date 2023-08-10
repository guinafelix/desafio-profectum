package com.profectum.desafio.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	private String senha;
	
	@ManyToOne(targetEntity = Perfil.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="perfil_id")
	private Perfil perfil;
	
	
	public Usuario(String nome, Curso curso, String matricula, Perfil perfil, String senha) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
		this.perfil = perfil;
		this.senha = senha;
	}
	
	public Usuario() {
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


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
