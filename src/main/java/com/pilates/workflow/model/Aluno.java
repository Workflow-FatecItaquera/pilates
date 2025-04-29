package com.pilates.workflow.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Aluno")
public class Aluno {
	
	@Id
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private Date dataNascimento;
	private int plano;
	private String status;
	private List<MetodoPagamento> pagamentos;
	private List<PresencaEvento> historico;
	
	public Aluno() {}
	
	public Aluno(int id, String nome, String email, String senha, String telefone, Date dataNascimento, int plano, String status,
			List<MetodoPagamento> pagamentos, List<PresencaEvento> historico) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.plano = plano;
		this.status = status;
		this.pagamentos = pagamentos;
		this.historico = historico;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getPlano() {
		return plano;
	}
	public void setPlano(int plano) {
		this.plano = plano;
	}
	public List<MetodoPagamento> getPagamentos() {
		return pagamentos;
	}
	public void setPagamentos(List<MetodoPagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	public List<PresencaEvento> getHistorico() {
		return historico;
	}
	public void setHistorico(List<PresencaEvento> historico) {
		this.historico = historico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
