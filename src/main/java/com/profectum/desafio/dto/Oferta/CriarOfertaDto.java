package com.profectum.desafio.dto.Oferta;

import java.util.List;

public class CriarOfertaDto {
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
}
