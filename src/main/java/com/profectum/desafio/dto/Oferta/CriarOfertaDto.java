package com.profectum.desafio.dto.Oferta;

import java.util.List;

import com.profectum.desafio.models.Curso;

public class CriarOfertaDto {
	private Curso curso;
	private int semestre;
	private List<Long> disciplinasId;
	
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public List<Long> getDisciplinasId() {
		return disciplinasId;
	}
	public void setDisciplinasId(List<Long> disciplinasId) {
		this.disciplinasId = disciplinasId;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	
}
