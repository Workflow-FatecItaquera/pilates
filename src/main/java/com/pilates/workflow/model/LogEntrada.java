package com.pilates.workflow.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LogEntrada")
public class LogEntrada {
	
	@Id
	private String id;
	@DBRef
	private Aluno aluno;
	private Date data;
	
	public LogEntrada() {}

	public LogEntrada(String id, Aluno aluno, Date data) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

}
