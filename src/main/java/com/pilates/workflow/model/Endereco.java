package com.pilates.workflow.model;

public class Endereco {
	
	private String logradouro;
	private String cep;
	private int numero;
	private String estado;
	private String cidade;
	private String bairro;
	private String complemento;
	
	public Endereco() {}
	
	public Endereco(String logradouro, String cep, int numero, String estado, String cidade, String bairro, String complemento) {
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.complemento = complemento;
	}
	
	public Endereco(String logradouro, String cep, int numero, String estado, String cidade, String bairro) {
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCidade(String cidade){
		this.cidade = cidade;
	}

	public void setBairro(String bairro){
		this.bairro = bairro;
	}

	public String getCidade(){
		return cidade;
	}

	public String getBairro(){
		return bairro;
	}

}
