package com.pilates.workflow.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "Instrutor")
public class Instrutor {
	
	@Id
	private String id;
	private String nome;
	private String sobrenome;
	private String email;
	private String cpf;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	private String senha;
	private String telefone;
	private Endereco endereco;
	
	public Instrutor() {}
	
	public Instrutor(String id) {
		this.id = id;
	}

	public Instrutor(String email, String senha){
		this.email = email;
		this.senha = senha;
	}

	public Instrutor(String id, String nome, String sobrenome, String email, String cpf, Date dataNascimento, String senha, String telefone, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Instrutor(String id, String nome, String sobrenome, String email, String cpf, Date dataNascimento, String telefone, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	public String getCpf(){
		return cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
