package com.profectum.desafio.dto.Oferta;

public class CriarOfertaDto {
	private long cursoId;
	private long disciplinaId;
	private int semestre;
	
	public long getCursoId() {
		return cursoId;
	}
	public void setCursoId(long cursoId) {
		this.cursoId = cursoId;
	}
	public long getDisciplinaId() {
		return disciplinaId;
	}
	public void setDisciplinaId(long disciplinaId) {
		this.disciplinaId = disciplinaId;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
}
