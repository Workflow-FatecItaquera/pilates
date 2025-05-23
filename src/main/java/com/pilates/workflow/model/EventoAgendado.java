package com.pilates.workflow.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EventoAgendado")
public class EventoAgendado {

	@Id
	private String id;
    private Date data;
    private String descricao;
    private List<String> alunos;
    @DBRef
    private Instrutor instrutor;
    private String tipo;

    public EventoAgendado() {}

	public EventoAgendado(String id, Date data, String descricao, List<String> alunos, Instrutor instrutor,
			String tipo) {
		super();
		this.id = id;
		this.data = data;
		this.descricao = descricao;
		this.alunos = alunos;
		this.instrutor = instrutor;
		this.tipo = tipo;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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