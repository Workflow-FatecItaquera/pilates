package com.pilates.workflow.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "Aluno")
public class Aluno {
	
	@Id
	private String id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String senha;
	private String telefone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	@DBRef
	private Assinatura plano;
	private String status;
	private List<MetodoPagamento> pagamentos;
	private List<EventoAgendado> historico;
	private Endereco endereco;
	
	public Aluno() {}
	
	public Aluno(String id) {
		this.id = id;
	}
	
	public Aluno(String id, String nome, String sobrenome, String cpf, String email, String senha, String telefone, Date dataNascimento, Assinatura plano, String status,
			List<MetodoPagamento> pagamentos, List<EventoAgendado> historico, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.plano = plano;
		this.status = status;
		this.pagamentos = pagamentos;
		this.historico = historico;
		this.endereco = endereco;
	}

	public Aluno(String id, String nome, String sobrenome, String cpf, String email, String senha, String telefone, Date dataNascimento, Assinatura plano,
			List<MetodoPagamento> pagamentos, List<EventoAgendado> historico, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.plano = plano;
		this.status = "ativo";
		this.pagamentos = pagamentos;
		this.historico = historico;
		this.endereco = endereco;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	public String getCpf(){
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	public Assinatura getPlano() {
		return plano;
	}
	public void setPlano(Assinatura plano) {
		this.plano = plano;
	}
	public List<MetodoPagamento> getPagamentos() {
		return pagamentos;
	}
	public void setPagamentos(List<MetodoPagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}
	public List<EventoAgendado> getHistorico() {
		return historico;
	}
	public void setHistorico(List<EventoAgendado> historico) {
		this.historico = historico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
