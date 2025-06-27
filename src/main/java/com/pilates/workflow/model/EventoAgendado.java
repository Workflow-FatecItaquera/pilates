package com.pilates.workflow.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "EventoAgendado")
public class EventoAgendado {

	@Id
	private String id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
	// @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private String horaInicio;
	// @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private String horaTermino;
    private String sala;
    private List<Aluno> alunos;
    @DBRef
    private Instrutor instrutor;
    private String tipo;

    public EventoAgendado() {}

	public EventoAgendado(String id, Date data, String sala, List<Aluno> alunos, Instrutor instrutor,
			String tipo, String horaInicio, String horaTermino) {
		super();
		this.id = id;
		this.data = data;
		this.sala = sala;
		this.alunos = alunos;
		this.instrutor = instrutor;
		this.tipo = tipo;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
	}

	public String getHoraInicio(){
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio){
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino(){
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino){
		this.horaTermino = horaTermino;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    
}