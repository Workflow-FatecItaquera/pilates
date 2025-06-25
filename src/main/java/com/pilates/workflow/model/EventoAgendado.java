package com.pilates.workflow.model;

import java.time.LocalTime;
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
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horaInicio;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horaTermino;
    private String sala;
    private List<String> alunos;
    @DBRef
    private Instrutor instrutor;
    private String tipo;

    public EventoAgendado() {}

	public EventoAgendado(String id, Date data, String sala, List<String> alunos, Instrutor instrutor,
			String tipo, LocalTime horaInicio, LocalTime horaTermino) {
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

	public LocalTime getHoraInicio(){
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio){
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraTermino(){
		return horaTermino;
	}

	public void setHoraTermino(LocalTime horaTermino){
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

	public List<String> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<String> alunos) {
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